package br.com.caelum.mobileconf;

import br.com.caelum.mobileconf.util.BuscaCarrosTask;
import android.app.Activity;
import android.os.Bundle;

public class ListagemActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem);
		
//		CarroDAO dao = new CarroDAO(this);
//		List<Carro> carros = dao.lista();
//		dao.close();
//		
//		ListView listaCarros = (ListView) findViewById(R.id.lista_carros);
//		ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(this, android.R.layout.simple_expandable_list_item_1, carros);
//		listaCarros.setAdapter(adapter);
		
		new BuscaCarrosTask(this).execute();
	}

}
