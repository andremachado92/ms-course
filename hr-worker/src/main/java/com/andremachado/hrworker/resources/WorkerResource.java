package com.andremachado.hrworker.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andremachado.hrworker.entities.Worker;
import com.andremachado.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
	    System.out.print("Port: "+env.getProperty("local.server.port"));
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
}