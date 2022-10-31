package com.andremachado.hruser.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andremachado.hruser.entities.User;
import com.andremachado.hruser.repositories.UserRepository;

@Controller
@RequestMapping(value ="/users" )
public class UserResource {

	
	@Autowired
	private UserRepository repository;


	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
	    User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam(value = "email", required = false) 
	                                     String email) {
	    User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}	
	

}
