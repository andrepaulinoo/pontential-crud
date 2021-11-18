package com.gazin.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DeveloperController {

	@Autowired
	DeveloperRepository repository;
	
	@GetMapping("/developers")
	public List<Developer> getAllDevelopers() {
		return repository.findAll();
	}
	
	@GetMapping("/developers/{id}")
	public Developer getDeveloperById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/developers")
	Developer newDeveloper(@RequestBody Developer newDeveloper) {
	    return repository.save(newDeveloper);
	  }
	
	@PutMapping("/developers/{id}")
	Developer updateDeveloper(@RequestBody Developer newDeveloper, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(developer -> {
	    	developer.setNome(newDeveloper.getNome());
	    	developer.setSexo(newDeveloper.getSexo());
	    	developer.setIdade(newDeveloper.getIdade());
	    	developer.setHobby(newDeveloper.getHobby());
	    	developer.setDatanascimento(newDeveloper.getDatanascimento());
	        return repository.save(developer);
	      })
	      .orElseGet(() -> {
	    	newDeveloper.setId(id);
	        return repository.save(newDeveloper);
	      });
	  }
	
	@DeleteMapping("/developers/{id}")
	public void deleteDeveloper(@PathVariable Long id) {
		repository.deleteById(id);
		
	}
}
