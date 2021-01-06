package com.example.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable long id) throws Exception {
		if (id == 0l)
			throw new Exception("Invalid Id 0");
		return "ID : "+id;
	}

	@GetMapping("/value/{id}")
	public int findValueById(@PathVariable long id) throws Exception {
		if(id == 1) return 81600;
		if(id == 2) return 82000;
		if(id==3) return 83000;

		throw new Exception("Invalid ID");
	}

	@PutMapping(value="/value/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public long updateValue(
			@PathVariable("id") final long id, @RequestBody long value) {
		return value;
	}
}
