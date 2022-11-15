package com.masai.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Services;
import com.masai.model.User;
import com.masai.Servicelayer.ServiceServicelayerImpl;
import com.masai.Servicelayer.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private ServiceServicelayerImpl serviceServicelayerImpl;

	
	@PostMapping("/")
	public  User  saveUser(@RequestBody User er) {
		User user= userServiceImpl.createUser(er);
		return user;
		
	}

	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user, @RequestParam(required = false) String key) {

		return userServiceImpl.updateUser(user, key);
	}

	

	@GetMapping("/Entries")
	public ResponseEntity<List<Services>> getEntries(String key){
		List<Services> s=	serviceServicelayerImpl.getAllEntity(key);
		
		
		
		return new ResponseEntity<List<Services>>(s,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/random")
	public ResponseEntity<Services> getrendomEntries(String title,String key){
		Services s=	serviceServicelayerImpl.getEntity(key, key);
		
		
		
		return new ResponseEntity<Services>(s,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/catogory")
	public ResponseEntity<List<String>> getallcatogory(String key){
		List<String> s=	serviceServicelayerImpl.getallCatagory(key);
		
		
		
		return new ResponseEntity<List<String>>(s,HttpStatus.ACCEPTED);
		
	}

}