package br.com.caelum.mobileconf.fragment.estrategias;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import br.com.caelum.mobileconf.CarrosActivity;
import br.com.caelum.mobileconf.R;
import br.com.caelum.mobileconf.fragment.DetalhesFragment;
import br.com.caelum.mobileconf.fragment.ListagemFragment;
import br.com.caelum.mobileconf.modelo.Carro;

public class ConteudoSmart implements Conteudo {

	private CarrosActivity activity;

	public ConteudoSmart(CarrosActivity activity) {
		this.activity = activity;

		FragmentManager manager = activity.getSupportFragmentManager();

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.unico, new ListagemFragment());
		transaction.commit();
	}

	public void lidaComSelecaoDo(Carro carroSelecionado) {
		FragmentManager manager = activity.getSupportFragmentManager();

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.unico,
				DetalhesFragment.fragmentComCarro(carroSelecionado));
		
		transaction.commit();
	}

}
