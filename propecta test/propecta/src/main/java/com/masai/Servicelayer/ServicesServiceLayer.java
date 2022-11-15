package com.masai.Servicelayer;

import java.util.List;

import com.masai.model.Services;

// this layer has all method to get post service
public interface ServicesServiceLayer {

	public Services saveEntity(Services service,String key) throws Exception;
	public List<Services> getAllEntity(String key )throws Exception;
	public Services getEntity(String title ,String key)throws Exception;
	public List<String> getallCatagory(String key)throws Exception;
}
