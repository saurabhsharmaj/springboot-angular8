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

import com.sample.im.model.Contact;
import com.sample.im.repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }
    
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<Contact> save(@RequestBody Contact contact){
        return new ResponseEntity<Contact>(repository.save(contact),HttpStatus.OK);
    }
    
    @PutMapping(path = {})
    public ResponseEntity<Contact> update(@RequestBody Contact contact){
        return new ResponseEntity<Contact>(repository.save(contact),HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<String> deleteById(@PathVariable long id){
        repository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
       
    }
}
