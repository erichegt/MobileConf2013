package br.com.caelum.mobileconf.util;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.mobileconf.DetalhesActivity;
import br.com.caelum.mobileconf.ListagemActivity;
import br.com.caelum.mobileconf.R;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.persistence.CarroDAO;

public class BuscaCarrosTask extends AsyncTask<Void, Void, List<Carro>>{

	private ListagemActivity activity;
	private ProgressDialog dialog;

	public BuscaCarrosTask(ListagemActivity activity) {
		this.activity = activity;
	}
	
	@Override
	protected void onPreExecute() {
		dialog = ProgressDialog.show(activity, "Acessando servidor", "Buscando carros cadastrados...", true, true);
	}
	
	@Override
	protected List<Carro> doInBackground(Void... params) {
		
		CarroDAO dao = new CarroDAO(activity);
		List<Carro> carros = dao.lista();
		dao.close();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			MyLog.e("Zica no Thread Sleep");
		}
		
		return carros;
	}
	
	@Override
	protected void onPostExecute(final List<Carro> result) {
		//???
		
		MyLog.i("carros: "+result);
		
		ListView listaCarros = (ListView) activity.findViewById(R.id.lista_carros);
		ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(activity, android.R.layout.simple_expandable_list_item_1, result);
		listaCarros.setAdapter(adapter);
		
		listaCarros.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View linha, int posicao,
					long id) {
				
				Carro carroSelecionado = result.get(posicao);
				
				Intent irParaFormulario = new Intent(activity, DetalhesActivity.class);
				irParaFormulario.putExtra("carroSelecionado", carroSelecionado);
				
				activity.startActivity(irParaFormulario);
			}
		});
		
		dialog.dismiss();
		
		
	}

}
