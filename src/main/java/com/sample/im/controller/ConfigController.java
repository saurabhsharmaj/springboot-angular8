package com.sample.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.im.model.Config;
import com.sample.im.repository.ConfigRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping({"/config"})
@Api(value="config", description="Operations pertaining to configuration")
public class ConfigController {

	@Autowired
	private ConfigRepository repository;
	
	

	@GetMapping
	public List<Config> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Config> findById(@PathVariable Long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public ResponseEntity<Config> save(@RequestBody Config config){
		return new ResponseEntity<Config>(repository.save(config),HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Config> update(@RequestBody Config config){
		return new ResponseEntity<Config>(repository.save(config),HttpStatus.OK);
	}

	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		repository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
