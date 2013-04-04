package br.com.caelum.mobileconf.util;

import android.util.Log;

public class MyLog {
	public static void i(Object msg) {
		Log.i("INFO ---------", msg == null ? "null" :  msg.toString());
	}

	public static void e(Object msg) {
		Log.e("ERROR ---------", msg == null ? "null" :  msg.toString());
	}
}
