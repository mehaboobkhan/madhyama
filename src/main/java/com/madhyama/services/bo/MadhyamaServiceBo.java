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
	 * <b>@see https://api.covid19api.com/</br>
	 * <b>@since</b> 1.0 </br>
	 */
	public String getCovid19Data(String path) throws Exception;

	/**
	 * <p>Gets Global Health Observatory - World Health Organization's data and statistics content</p>
	 * <b>@param</b> accepts path String</br>
	 * <b>@return</b> a json String response</br>
	 * <b>@see //https://apps.who.int/gho/athena/public_docs/examples.html</br>
	 * <b>@since</b> 1.0 </br>
	 */
	public String getGHOData(String path) throws Exception;

}
