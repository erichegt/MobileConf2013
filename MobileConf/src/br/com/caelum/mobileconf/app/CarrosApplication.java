package br.com.caelum.mobileconf.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.modelo.Combustivel;
import br.com.caelum.mobileconf.modelo.Fabricante;
import br.com.caelum.mobileconf.persistence.DAO;

public class CarrosApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		SharedPreferences preferences = getSharedPreferences("configs", Context.MODE_PRIVATE);
		
		boolean bancoPopulado = preferences.getBoolean("banco", false);
		
		if (!bancoPopulado) {
			Carro gol = new Carro("Gol", 1.0, Fabricante.VW, Combustivel.FLEX, 2010);
			Carro golf = new Carro("Golf", 2.0, Fabricante.VW, Combustivel.FLEX, 2010);
			Carro corsa = new Carro("Corsa", 1.0, Fabricante.GM, Combustivel.GASOLINA, 1998);
			Carro agile = new Carro("Agile", 1.4, Fabricante.GM, Combustivel.GASOLINA, 2010);
			Carro palio = new Carro("Palio", 1.3, Fabricante.FIAT, Combustivel.FLEX, 2013);
			Carro punto = new Carro("Punto", 1.6, Fabricante.FIAT, Combustivel.FLEX, 2013);
			
			DAO dao = new DAO(this);
			
			dao.save(gol);
			dao.save(golf);
			dao.save(agile);
			dao.save(corsa);
			dao.save(punto);
			dao.save(palio);
			
			dao.close();
			
			Editor editor = preferences.edit();
			editor.putBoolean("banco", true);
			editor.commit();
		}
	}

}
