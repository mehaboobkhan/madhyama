package com.madhyama.services.bo.impl;

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
	public String getCovid19Data(String path) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		return commonUtils.getDataFromURI(URI_COVID19+path);
	}

}
