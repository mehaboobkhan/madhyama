package com.madhyama.services.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.madhyama.services.bo.MadhyamaServiceBo;
import com.madhyama.services.constants.MadhyamaURIConstants;

/**
 * This is the entry point for Madhyama REST apis endpoint
 * 
 * @author Mehaboobkhan Patgoankar
 * 
 */
@RestController	
public class MadhyamaController {

	@Autowired
	private MadhyamaServiceBo madhyamaServiceBo;

	/**
	 * <p>API Get request to get all the API Details in Madhyama</p>
	 * <b>@param</b> accepts a path variable</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	@RequestMapping(value = MadhyamaURIConstants.MADHYAMA_APIS, method = RequestMethod.GET)
	public @ResponseBody String getMadhyamaAPIs() throws Exception{
		return madhyamaServiceBo.getMadhyamaAPIs();
	}
	
	/**
	 * <p>API Get request to get Covid-19 data</p>
	 * <b>@param</b> accepts a path variable</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	@RequestMapping(value = MadhyamaURIConstants.MADHYAMA_COVID19+"/**", method = RequestMethod.GET)
	public @ResponseBody String getCovid19Data(HttpServletRequest request) throws Exception{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		path = path.substring(MadhyamaURIConstants.MADHYAMA_COVID19.length()+1,path.length());
		return madhyamaServiceBo.getCovid19Data(path);
	}

	/**
	 * <p>API Get request to get Global Health Observatory - World Health Organization's data and statistics content</p>
	 * <b>@param</b> accepts a path variable</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	@RequestMapping(value = MadhyamaURIConstants.MADHYAMA_GHO+"/**", method = RequestMethod.GET)
	public @ResponseBody String getGHOData(HttpServletRequest request) throws Exception{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		path = path.substring(MadhyamaURIConstants.MADHYAMA_GHO.length()+1,path.length())+"/";
		return madhyamaServiceBo.getGHOData(path);
	}

	/**
	 * <p>API Get request to get various Data and Databases from World Bank</p>
	 * <b>@param</b> accepts a path variable</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	@RequestMapping(value = MadhyamaURIConstants.MADHYAMA_WORLD_BANK+"/**", method = RequestMethod.GET)
	public @ResponseBody String getWorldBankData(HttpServletRequest request) throws Exception{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		path = path.substring(MadhyamaURIConstants.MADHYAMA_WORLD_BANK.length()+1,path.length());
		return madhyamaServiceBo.getWorldBankData(path);
	}
}
