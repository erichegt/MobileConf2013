package br.com.caelum.mobileconf;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.util.AsyncDelagate;
import br.com.caelum.mobileconf.util.BuscaCarrosTask;

public class ListagemActivity extends Activity implements AsyncDelagate<List<Carro>> {

	private BuscaCarrosTask task;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.listagem);

//		Na UIThread? nem rola...
//		try {
//			HttpClient httpclient = new DefaultHttpClient();
//
//			HttpGet httpGet = new HttpGet(endereco);
//			HttpResponse resp = httpclient.execute(httpGet);
//
//			String jsonCarros = 
//					EntityUtils.toString(resp.getEntity());
//			// colocar no ListView
//			
//			//emulando o resquest:
//			 CarroDAO dao = new CarroDAO(this);
//			 List<Carro> carros = dao.lista();
//			 dao.close();
//			
//			 ListView listaCarros = (ListView) findViewById(R.id.lista_carros);
//			 ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(this,
//			 android.R.layout.simple_expandable_list_item_1, carros);
//			 listaCarros.setAdapter(adapter);
//		} catch (Exception e) {
//			// ...
//		}


		task = new BuscaCarrosTask(this);
		task.execute();
	}
	
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		task.cancel(true);
	}
	@Override
	public Context getContext() {
		return this;
	}



	@Override
	public void lidaCom(final List<Carro> result) {
		ListView listaCarros = (ListView) findViewById(R.id.lista_carros);
		ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(this, android.R.layout.simple_expandable_list_item_1, result);
		listaCarros.setAdapter(adapter);
		
		listaCarros.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View linha, int posicao,	long id) {
				
				Carro carroSelecionado = result.get(posicao);
				
				Intent irParaDetalhes = new Intent(ListagemActivity.this, DetalhesActivity.class);
				irParaDetalhes.putExtra("carroSelecionado", carroSelecionado);
				
				startActivity(irParaDetalhes);
			}
		});
	}

}
