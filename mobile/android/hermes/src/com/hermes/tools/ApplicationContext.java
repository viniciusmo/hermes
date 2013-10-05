package com.hermes.tools;

import android.content.Context;
import android.content.res.Resources;

public class ApplicationContext {
	private static Context context;

	public static Context context() {
		return context;
	}

	public static Resources res() {
		return context.getResources();
	}

	public static void setContext(Context context) {
		ApplicationContext.context = context;
	}
}
