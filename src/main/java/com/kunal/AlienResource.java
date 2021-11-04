package com.kunal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AlienResource {

	@Autowired
	private AlienRepository repo;
	
	@GetMapping("aliens")
	public List<Alien> getAliens() {
		List<Alien> aliens = (List<Alien>) repo.findAll();
		
		return aliens;
	}
	
	@GetMapping("aliens/{id}")
	public Alien getAlien(@PathVariable int id) {
		System.out.println("getAlien called...");
		Optional<Alien> optionalAlien = repo.findById(id);
		
		Alien a = null;
		if(optionalAlien.isPresent()) {
			a = optionalAlien.get();
		}
		
		return a;
	}
	
	@PostMapping("aliens/alien")
	public Alien createAlien(@RequestBody Alien a) {
		if(repo.existsById(a.getId()))
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Duplicate entry", null);
		
		repo.save(a);
		return a;
	}
	
	@PutMapping("aliens/alien")
	public Alien updateAlien(@RequestBody Alien a) {
		if(!repo.existsById(a.getId()))
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entry is not present", null);
	
		repo.deleteById(a.getId());	// deleting existing alien with given id
		repo.save(a);	// adding the updated alien
		
		return a;
	}
	
	@DeleteMapping("aliens/{id}")
	public Alien deleteAlien(@PathVariable int id) {
		if(!repo.existsById(id))
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entry is not present", null);

		Alien a = repo.findById(id).get();
		repo.delete(a);
		
		return a;
	}
	
}