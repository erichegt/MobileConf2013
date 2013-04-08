package br.com.caelum.mobileconf.fragment.estrategias;

import br.com.caelum.mobileconf.CarrosActivity;
import br.com.caelum.mobileconf.R;

public class FabricaDeConteudo {
	
	public static Conteudo getConteudo(CarrosActivity activity) {
		boolean ehTabletNaHorizontal = activity.getResources().getBoolean(R.bool.ehTabletNaHorizontal);
		
		if (ehTabletNaHorizontal) {
			return new ConteudoTablet(activity);
		} else {
			return new ConteudoSmart(activity);
		}
			
	}

}
