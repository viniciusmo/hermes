package com.hermes.tools;

import android.content.Context;

public class ApplicationContext {
	private static Context context;

	public static Context context() {
		return context;
	}

	public static void setContext(Context context) {
		ApplicationContext.context = context;
	}
}
