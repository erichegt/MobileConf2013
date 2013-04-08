package br.com.caelum.mobileconf.fragment.estrategias;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import br.com.caelum.mobileconf.CarrosActivity;
import br.com.caelum.mobileconf.R;
import br.com.caelum.mobileconf.fragment.DetalhesFragment;
import br.com.caelum.mobileconf.fragment.ListagemFragment;
import br.com.caelum.mobileconf.modelo.Carro;

public class ConteudoTablet implements Conteudo {

	private CarrosActivity activity;

	public ConteudoTablet(CarrosActivity activity) {
		this.activity = activity;

		FragmentManager manager = activity.getSupportFragmentManager();

		FragmentTransaction transaction = manager.beginTransaction();

		transaction.replace(R.id.esquerda, new ListagemFragment());
		transaction.replace(R.id.direita,
				DetalhesFragment.fragmentComCarro(null));

		transaction.commit();
	}

	public void lidaComSelecaoDo(Carro carroSelecionado) {
		FragmentManager manager = activity.getSupportFragmentManager();

		DetalhesFragment detalhes = (DetalhesFragment) manager
				.findFragmentById(R.id.direita);
		
		detalhes.seleciona(carroSelecionado);
	}

}
