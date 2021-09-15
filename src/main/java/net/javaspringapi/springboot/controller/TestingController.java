package net.javaspringapi.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaspringapi.springboot.exception.ResourceNotFoundException;
import net.javaspringapi.springboot.model.Testing;
import net.javaspringapi.springboot.repository.TestingRepository;

@RestController
@RequestMapping("/api/v1/")
public class TestingController {
	
	@Autowired
	private TestingRepository testingRespository;
	
	//get testing
	
	@GetMapping("testings")
	public List<Testing> getAllTesting(){
		return this.testingRespository.findAll();
	}
	
	//get testing by id
	@GetMapping("/testing/{id}")
	public ResponseEntity<Testing> getTestingById(@PathVariable(value = "id") Long testingId)
		throws ResourceNotFoundException {
		Testing testing = testingRespository.findById(testingId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found for id :: " + testingId));
		
		return ResponseEntity.ok().body(testing);
	}
	
	//save testing
	@PostMapping("testing")
	public Testing createTesting(@RequestBody Testing testing) {
		return this.testingRespository.save(testing);
	}
	//update testing
	//delete testing
}
