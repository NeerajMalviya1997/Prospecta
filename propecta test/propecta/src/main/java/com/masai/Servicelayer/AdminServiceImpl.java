package com.masai.Servicelayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;
import com.masai.Repository.AdminDao;
import com.masai.Repository.AminSessionDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private AminSessionDao adminSessionDAO;
	
	@Override
	public Admin createAdmin(Admin admin) {
		Optional<Admin> opt= adminDao.findByMobileNo(admin.getMobileNo());
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return adminDao.save(admin);
	}

}
