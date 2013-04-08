package br.com.caelum.mobileconf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import br.com.caelum.mobileconf.fragment.estrategias.Conteudo;
import br.com.caelum.mobileconf.fragment.estrategias.FabricaDeConteudo;
import br.com.caelum.mobileconf.modelo.Carro;

public class CarrosActivity extends FragmentActivity {

	private Conteudo conteudo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carros);

		conteudo = FabricaDeConteudo.getConteudo(this);

		// FragmentManager manager = getSupportFragmentManager();
		//
		// FragmentTransaction transaction = manager.beginTransaction();
		//
		// if (isTabletNaHorizontal()) {
		// transaction.replace(R.id.esquerda, new ListagemFragment());
		// transaction.replace(R.id.direita,
		// DetalhesFragment.fragmentComCarro(null));
		// } else {
		// transaction.replace(R.id.unico, new ListagemFragment());
		// }
		//
		// transaction.commit();
	}

	public void lidaComSelecaoDo(Carro carroSelecionado) {
		conteudo.lidaComSelecaoDo(carroSelecionado);

		// FragmentManager manager = getSupportFragmentManager();
		//
		// if (isTabletNaHorizontal()) {
		// DetalhesFragment detalhes = (DetalhesFragment) manager
		// .findFragmentById(R.id.direita);
		// detalhes.seleciona(carroSelecionado);
		// } else {
		// FragmentTransaction transaction = manager.beginTransaction();
		// transaction.replace(R.id.unico,
		// DetalhesFragment.fragmentComCarro(carroSelecionado));
		// transaction.commit();
		// }
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.compras) {

			Intent i = new Intent(Intent.ACTION_VIEW);
			String uriDaAcao = "busao://localhost/acao/customizada/"+
					getResources().getString(R.string.tag_intent_implicita); //mussum, restart...
			
			i.setData(Uri.parse(uriDaAcao));
			
			startActivity(i);

			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_principal, menu);

		return super.onCreateOptionsMenu(menu);
	}

	public boolean isTabletNaHorizontal() {
		return getResources().getBoolean(R.bool.ehTabletNaHorizontal);
	}
}
