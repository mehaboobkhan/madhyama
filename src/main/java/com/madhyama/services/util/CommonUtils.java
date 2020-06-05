package com.madhyama.services.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class contains all the generic utilities used across the application.
 * 
 * @author Mehaboobkhan Patgoankar
 * 
 */
public class CommonUtils {

	/**
	 <p>Gets data from http url</p></br>
	 <b>@param</b> accepts uri</br>
	 <b>@return</b>string data</b> </br>
	 <b>@see </br>
	 <b>@since</b> 1.0 </br>
	 */
	public String getDataFromURI(String uri) {
		StringBuffer response = new StringBuffer();
		try {
			URL urlForGetRequest = new URL(uri);
			HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
			conection.setRequestMethod("GET");
			int responseCode = conection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				try(BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()))){
					String readLine = null;
					while ((readLine = in.readLine()) != null) {
						response.append(readLine);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();
	}

}
