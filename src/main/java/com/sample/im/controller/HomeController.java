package com.sample.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.im.repository.ContactRepository;

@Controller
@RequestMapping({"/contacts"})
public class HomeController {

    private ContactRepository repository;

    HomeController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    @GetMapping(path = {"/home"})
    public String home(){
        return "index";
    }
   
}
