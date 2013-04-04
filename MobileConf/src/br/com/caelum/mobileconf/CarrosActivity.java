package br.com.caelum.mobileconf;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import br.com.caelum.mobileconf.fragment.DetalhesFragment;
import br.com.caelum.mobileconf.fragment.ListagemFragment;
import br.com.caelum.mobileconf.modelo.Carro;

public class CarrosActivity extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carros);
		
		FragmentManager manager = getSupportFragmentManager();
		
		FragmentTransaction transaction = manager.beginTransaction();
		
		if (isTabletNaHorizontal()) {
			transaction.replace(R.id.esquerda, new ListagemFragment());
			transaction.replace(R.id.direita, DetalhesFragment.fragmentComCarro(null));
		} else {
			transaction.replace(R.id.unico, new ListagemFragment());
		}
		
		transaction.commit();
	}

	public void lidaComSelecaoDo(Carro carroSelecionado) {
		FragmentManager manager = getSupportFragmentManager();
		
		if (isTabletNaHorizontal()) {
			DetalhesFragment detalhes = (DetalhesFragment) manager.findFragmentById(R.id.direita);
			detalhes.seleciona(carroSelecionado);
		} else {
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.replace(R.id.unico, DetalhesFragment.fragmentComCarro(carroSelecionado));
			transaction.commit();
		}
	}

	public boolean isTabletNaHorizontal() {
		return getResources().getBoolean(R.bool.ehTabletNaHorizontal);
	}
}
