package com.masai.Servicelayer;

import com.masai.model.Admin;
import com.masai.model.AdminDto;


public interface AdminLoginService {

	public String logIntoAccount(Admin adminDTO);
	
	public String logOutAccount(String key);

	public String logIntoAccount(AdminDto adminDTO);
}
