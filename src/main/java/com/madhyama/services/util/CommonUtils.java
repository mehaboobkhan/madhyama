package com.madhyama.services.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;

/**
 * This class contains all the generic utilities used across the application.
 * 
 * @author Mehaboobkhan Patgoankar
 * 
 */
public class CommonUtils {

	/**
	 <p>Gets data from http url</p></br>
	 <b>@param</b> accepts url</br>
	 <b>@return</b>string data</b> </br>
	 <b>@see </br>
	 <b>@since</b> 1.0 </br>
	 */
	public String getDataFromURL(String url) {
		StringBuffer response = new StringBuffer();
		try {
			URL urlForGetRequest = new URL(url);
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


	/**
	 <p>Gets XML data from http url</p></br>
	 <b>@param</b> accepts url</br>
	 <b>@return</b>XML string data</b> </br>
	 <b>@see </br>
	 <b>@since</b> 1.0 </br>
	 */
	public String getXMLDataFromURL(String url) {
		StringBuffer response = new StringBuffer();
		try {
			InputStreamReader inReader = new InputStreamReader(new URL(url).openStream());
			BufferedReader reader = new BufferedReader(inReader);
			String str;
			while((str = reader.readLine())!= null){
				response.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();
	}



	/**
	 <p>Converts XML to JSON String</p></br>
	 <b>@param</b> accepts xml String</br>
	 <b>@return</b> JSON string</b> </br>
	 <b>@see </br>
	 <b>@since</b> 1.0 </br>
	 */
	public String convertXMLToJSON(String xmlString) {
		JSONObject json = new JSONObject();
		try {
			json = XML.toJSONObject(xmlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

}
