package com.madhyama.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	 * <p>API Get request to get Covid-19 data</p>
	 * <b>@param</b> accepts a path variable</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	@RequestMapping(value = MadhyamaURIConstants.MADHYAMA_COVID19+"/{path}", method = RequestMethod.GET)
	public @ResponseBody String getJobStatus(@PathVariable("path") String path) throws Exception{
		return madhyamaServiceBo.getCovid19Data(path);
	}
}
