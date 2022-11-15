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

        import com.masai.model.Admin;
import com.masai.model.Services;
import com.masai.Servicelayer.AdminServiceImpl;
import com.masai.Servicelayer.ServiceServicelayerImpl;
        
@RestController
@RequestMapping("/admin")
public class AdminController {

    

    @Autowired
    private AdminServiceImpl adminServiceImpl;
	@Autowired
	private ServiceServicelayerImpl serviceServicelayerImpl;
  

   
    @PostMapping("/")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminServiceImpl.createAdmin(admin);
    }

    
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin, @RequestParam(required = false) String key) {

        return adminServiceImpl.updateAdmin(admin, key);
    }
    @PostMapping("/Entries")
	public ResponseEntity<Services> addservices(@RequestBody Services service,String key){
		Services s=	serviceServicelayerImpl.saveEntity(service, key);
		
		
		
		return new ResponseEntity<Services>(s,HttpStatus.ACCEPTED);
		
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

