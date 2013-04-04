package br.com.caelum.mobileconf.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.mobileconf.CarrosActivity;
import br.com.caelum.mobileconf.R;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.persistence.CarroDAO;

public class ListagemFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View lista = inflater.inflate(R.layout.listagem, null);

		ListView listaCarros = (ListView) lista.findViewById(R.id.lista_carros);
		populaDadosNa(listaCarros);
		
		listaCarros.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				Carro carroSelecionado = (Carro) adapter.getItemAtPosition(posicao);
				
				CarrosActivity activity = (CarrosActivity) getActivity();
				activity.lidaComSelecaoDo(carroSelecionado);
			}
		});

		return lista;
	}

	private void populaDadosNa(ListView listaCarros) {
		
		CarroDAO dao = new CarroDAO(getActivity());
		List<Carro> carros = dao.lista();
		dao.close();
		
		ArrayAdapter<Carro> adapter = new ArrayAdapter<Carro>(getActivity(),
				android.R.layout.simple_expandable_list_item_1, carros);
		
		listaCarros.setAdapter(adapter);
	}

}
