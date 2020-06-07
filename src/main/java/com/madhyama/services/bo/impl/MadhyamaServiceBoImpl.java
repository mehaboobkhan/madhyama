package com.madhyama.services.bo.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.madhyama.services.bo.MadhyamaServiceBo;
import com.madhyama.services.constants.URIConstants;
import com.madhyama.services.util.CommonUtils;

/**
 * This class implements MadhyamaServiceBO interface and implements all the custom operations related to Madhyama
 * 
 * @author Mehaboobkhan Patgoankar
 * 
 */
@Service
public class MadhyamaServiceBoImpl implements MadhyamaServiceBo, URIConstants {

	@Override
	public String getMadhyamaAPIs() throws Exception {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("madhyama.json");
		InputStreamReader inReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inReader);
		StringBuffer response = new StringBuffer();
		String str;
		while((str = reader.readLine())!= null){
			response.append(str);
		}
		/*CommonUtils commonUtils = new CommonUtils();
		return commonUtils.convertJSONToPrettyPrinterJSON(response.toString());*/
		return response.toString();
	}

	@Override
	public String getCovid19Data(String path) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		return commonUtils.getDataFromURL(URI_COVID19+path);
	}

	@Override
	public String getGHOData(String path) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		String GHOXMLData = commonUtils.getXMLDataFromURL(URI_GHO+path);
		return commonUtils.convertXMLToJSON(GHOXMLData);
	}

	@Override
	public String getWorldBankData(String path) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		String worldBankData = commonUtils.getXMLDataFromURL(URI_WORLD_BANK+path);
		return commonUtils.convertXMLToJSON(worldBankData);
	}

}
