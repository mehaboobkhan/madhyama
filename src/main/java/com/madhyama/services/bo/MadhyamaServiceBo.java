package com.madhyama.services.bo;

/**
 * This interface defines all the custom operations related to Madhyama.
 * 
 * @author Mehaboobkhan Patgoankar
 * 
 */
public interface MadhyamaServiceBo {

	/**
	 * <p>Gets covid19 data</p>
	 * <b>@param</b> accepts path String</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see </br>
	 * <b>@since</b> 1.0 </br>
	 */
	public String getCovid19Data(String path) throws Exception;
	
}
