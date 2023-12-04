package com.familytree.example.familytreeservice.controllers;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.repositories.AncestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AncestorController {

    @Autowired
    AncestorRepository ancestorRepository;

    @PostMapping(value = "/ancestors")
    public ResponseEntity<Ancestor> postAncestor(@RequestBody Ancestor ancestor) {
        ancestorRepository.save(ancestor);
        return new ResponseEntity<>(ancestor, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ancestors")
    public ResponseEntity<List<Ancestor>> getAncestors() {
        return new ResponseEntity<>(ancestorRepository.findAll(), HttpStatus.OK);
    }

}
