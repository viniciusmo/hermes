package com.hermes.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.hermes.exceptions.FailWebClientException;

public class WebClient {

	public static String getContent(String stringUrl) {
		URL url = null;
		StringBuilder content = new StringBuilder();
		try {
			url = new URL(stringUrl);
			URLConnection urlConnection;
			urlConnection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream(), "UTF-8"));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				content.append(inputLine);
			in.close();
		} catch (IOException e) {
			throw new FailWebClientException();
		}
		return content.toString();
	}

}
