package br.com.caelum.mobileconf.util;

import android.content.Context;

public interface AsyncDelagate<T> {
	Context getContext();
	
	void lidaCom(T resultado);
}
