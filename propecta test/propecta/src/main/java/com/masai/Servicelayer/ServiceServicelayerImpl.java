package com.masai.Servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.AminSessionDao;
import com.masai.Repository.ServiceDao;
import com.masai.Repository.UserSessionDAO;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.Services;


@Service
public class ServiceServicelayerImpl implements ServicesServiceLayer {
	
	@Autowired
	private ServiceDao  serviceDao;
	
	@Autowired
	private AminSessionDao adminsessionDao;
	
	@Autowired
    private UserSessionDAO userSessionDAO;

	@Override
	public Services saveEntity(Services service,String key)  {
		Optional<CurrentAdminSession> admin=adminsessionDao.findByUuid(key);
		if(admin.isEmpty()) {
			throw new RuntimeException("admin not found");
		}
		return serviceDao.save(service);
	}

	@Override
	public List<Services> getAllEntity(String key) {
		Optional<CurrentAdminSession> admin=adminsessionDao.findByUuid(key);
		if(admin.isEmpty()) {
			Optional<CurrentUserSession>	user=userSessionDAO.findByUuid(key);
			if(user.isEmpty()) {
				throw new RuntimeException("admin not found");
			}
		}
		List<Services> services=serviceDao.findAll();
		return services;
	}

	@Override
	public Services getEntity(String title, String key) {
		Optional<CurrentAdminSession> admin=adminsessionDao.findByUuid(key);
		if(admin.isEmpty()) {
			Optional<CurrentUserSession>	user=userSessionDAO.findByUuid(key);
			if(user.isEmpty()) {
				throw new RuntimeException("admin not found");
			}
		}
		
		Optional<Services> ser=serviceDao.findByTitle(title);
		return ser.get();
	}

	@Override
	public List<String> getallCatagory(String key) {
		Optional<CurrentAdminSession> admin=adminsessionDao.findByUuid(key);
		if(admin.isEmpty()) {
			Optional<CurrentUserSession>	user=userSessionDAO.findByUuid(key);
			if(user.isEmpty()) {
				throw new RuntimeException("admin not found");
			}
		}
		List<String> listofcatagory=new ArrayList<>();
		List<Services> servics=serviceDao.findAll();
		
		for(Services s: servics) {
			listofcatagory.add(s.getCategory());
		}
		return listofcatagory;
	}

}
