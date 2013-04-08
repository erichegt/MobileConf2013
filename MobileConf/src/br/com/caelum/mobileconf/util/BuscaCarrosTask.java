package br.com.caelum.mobileconf.util;

import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.persistence.CarroDAO;

public class BuscaCarrosTask extends AsyncTask<Void, Void, List<Carro>>{

	private AsyncDelagate<List<Carro>> quemMeChamou;
	private ProgressDialog dialog;

	public BuscaCarrosTask(AsyncDelagate<List<Carro>> delegate) {
		this.quemMeChamou = delegate;
	}
	
	@Override
	protected void onPreExecute() {
		dialog = ProgressDialog.show(quemMeChamou.getContext(), 
				"Acessando servidor", "Buscando carros cadastrados...", true, true);
	}
	
	@Override
	protected List<Carro> doInBackground(Void... params) {
		
		CarroDAO dao = new CarroDAO(quemMeChamou.getContext());
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
		this.quemMeChamou.lidaCom(result);
		
//		ListView listaCarros = (ListView) quemMeChamou.findViewById(R.id.lista_carros);
//		ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(quemMeChamou, android.R.layout.simple_expandable_list_item_1, result);
//		listaCarros.setAdapter(adapter);
//		
//		listaCarros.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> adapter, View linha, int posicao,	long id) {
//				
//				Carro carroSelecionado = result.get(posicao);
//				
//				Intent irParaDetalhes = new Intent(quemMeChamou, DetalhesActivity.class);
//				irParaDetalhes.putExtra("carroSelecionado", carroSelecionado);
//				
//				quemMeChamou.startActivity(irParaDetalhes);
//			}
//		});
		
		dialog.dismiss();
	}
}
