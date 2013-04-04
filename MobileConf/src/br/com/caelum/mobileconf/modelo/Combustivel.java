package br.com.caelum.mobileconf.modelo;

public enum Combustivel {
	ALCOOL{
		public String toString() { return "Álcool"; }
	}, 
	
	GASOLINA{
		public String toString() { return "Gasolina"; }
	},
	
	FLEX{
		public String toString() { return "Flex"; }
	};
}
