package com.sample.im.controller;

import java.util.List;

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

import com.sample.im.model.Feature;
import com.sample.im.repository.FeatureRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({"/feature"})
@Api(value="feature", description="Operations pertaining to feature")
public class FeatureController {

	private FeatureRepository repository;
	
	FeatureController(FeatureRepository featureRepository) {
		this.repository = featureRepository;
	}

	@ApiOperation(value = "View a list of available features list", response = Feature.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping
	public List<Feature> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Feature> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public ResponseEntity<Feature> save(@RequestBody Feature feature){
		return new ResponseEntity<Feature>(repository.save(feature),HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Feature> update(@RequestBody Feature feature){
		return new ResponseEntity<Feature>(repository.save(feature),HttpStatus.OK);
	}

	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable long id){
		repository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
