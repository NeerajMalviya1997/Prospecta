package com.masai.Servicelayer;


import com.masai.model.UserDto;

public interface UserLoginService {

	public String logIntoAccount(UserDto userDTO) throws Exception;
	
	public String logOutAccount(String key);
}
