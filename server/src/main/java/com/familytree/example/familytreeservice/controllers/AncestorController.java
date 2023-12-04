package com.familytree.example.familytreeservice.controllers;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.models.Gender;
import com.familytree.example.familytreeservice.repositories.AncestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AncestorController {

    @Autowired
    AncestorRepository ancestorRepository;

    @PostMapping(value = "/ancestors", consumes="application/json", produces ="application/json")
    public ResponseEntity<Ancestor> postAncestor(@RequestBody Ancestor ancestor) {
        ancestorRepository.save(ancestor);
        return new ResponseEntity<>(ancestor, HttpStatus.CREATED);
    }


}
