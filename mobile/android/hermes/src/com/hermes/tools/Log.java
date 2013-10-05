package com.hermes.tools;

public class Log {
	private static final String NAME_TAG = "LOG";

	public static void i(String log) {
		android.util.Log.i(NAME_TAG, log);
	}

	public static void e(String log) {
		android.util.Log.e(NAME_TAG, log);
	}

	public static void w(String log) {
		android.util.Log.w(NAME_TAG, log);
	}

	public static void d(String log) {
		android.util.Log.d(NAME_TAG, log);
	}
}
