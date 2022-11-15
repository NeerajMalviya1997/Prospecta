package com.masai.Servicelayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.Repository.UserDao;
import com.masai.Repository.UserSessionDAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Override
	public User createUser(User user) {
		
		
		Optional<User> opt= userDao.findByMobileNo(user.getMobileNo());
		
		if(opt.isPresent()) {
//			System.out.println("User already exist");
			throw new RuntimeException("User already exist");
		}
		
		userDao.save(user);
		return user;
		
	}

	@Override
	public User updateUser(User user, String key) {

		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
		
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return userDao.save(user);

	}

}
