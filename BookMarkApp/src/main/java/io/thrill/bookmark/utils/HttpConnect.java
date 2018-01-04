package io.thrill.bookmark.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class HttpConnect {
	 
	public static String downloadWebLink(String sourceUrl) throws MalformedURLException, URISyntaxException {
		URL url = new URI(sourceUrl).toURL();
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int respCode = conn.getResponseCode();
			if(respCode == 200) {		
				return IOUtil.read(conn.getInputStream());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
