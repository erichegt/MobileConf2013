package br.com.caelum.mobileconf.persistence;

import java.util.List;

import br.com.caelum.mobileconf.modelo.Carro;
import android.content.Context;

public class CarroDAO {
	
	private DAO dao;

	public CarroDAO(Context context) {
		dao = new DAO(context);
	}
	
	public List<Carro> lista() {
		return dao.listAll(Carro.class);
	}

	public void close() {
		dao.close();
	}
}
