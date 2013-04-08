package br.com.caelum.mobileconf;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import br.com.caelum.mobileconf.modelo.Carro;

public class DetalhesActivity extends Activity {
	
	//Sério mesmo?
	private static final String CARRO_SELECIONADO = "carroSelecionado";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhes);
		
		TextView modelo = (TextView) findViewById(R.id.modelo);
		TextView ano = (TextView) findViewById(R.id.ano);
		TextView fabricante = (TextView) findViewById(R.id.fabricante);
		TextView motorizacao = (TextView) findViewById(R.id.motorizacao);
		TextView combustivel = (TextView) findViewById(R.id.combustivel);
		
		Carro carroSelecionado = (Carro) getIntent().getSerializableExtra(CARRO_SELECIONADO);
		
		if (carroSelecionado != null) {
			modelo.setText(carroSelecionado.getModelo());
			ano.setText(carroSelecionado.getAno().toString());
			fabricante.setText(carroSelecionado.getMarca().toString());
			motorizacao.setText(String.format("%.1fL", carroSelecionado.getLitrosMotor()));
			combustivel.setText(carroSelecionado.getCombustivel().toString());
		}
		
	}

}
