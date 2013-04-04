package br.com.caelum.mobileconf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.caelum.mobileconf.R;
import br.com.caelum.mobileconf.modelo.Carro;

public class DetalhesFragment extends Fragment {

	private TextView modelo;
	private TextView ano;
	private TextView fabricante;
	private TextView motorizacao;
	private TextView combustivel;

	public static DetalhesFragment fragmentComCarro(Carro carro) {
		DetalhesFragment fragment = new DetalhesFragment();

		Bundle bundle = new Bundle();
		bundle.putSerializable("carro", carro);
		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View detalhes = inflater.inflate(R.layout.detalhes, null);

		modelo = (TextView) detalhes.findViewById(R.id.modelo);
		ano = (TextView) detalhes.findViewById(R.id.ano);
		fabricante = (TextView) detalhes.findViewById(R.id.fabricante);
		motorizacao = (TextView) detalhes.findViewById(R.id.motorizacao);
		combustivel = (TextView) detalhes.findViewById(R.id.combustivel);

		return detalhes;
	}

	@Override
	public void onResume() {
		super.onResume();
		colocaDadosDoCarroNaTela();
	}

	private void colocaDadosDoCarroNaTela() {
		Bundle arguments = getArguments();

		if (arguments != null && arguments.getSerializable("carro") != null) {
			Carro carro = (Carro) arguments.getSerializable("carro");
			modelo.setText(carro.getModelo());
			ano.setText(carro.getAno().toString());
			fabricante.setText(carro.getMarca().toString());
			motorizacao.setText(String.format("%.1fL", carro.getLitrosMotor()));
			combustivel.setText(carro.getCombustivel().toString());
		}
	}

	public void seleciona(Carro carro) {
		Bundle bundle = getArguments();
		
		bundle.putSerializable("carro", carro);
		colocaDadosDoCarroNaTela();
	}

}
