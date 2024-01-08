package com.familytree.example.familytreeservice.controllers;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.models.Event.Birth;
import com.familytree.example.familytreeservice.repositories.AncestorRepository;
import com.familytree.example.familytreeservice.repositories.BirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AncestorController {

    @Autowired
    AncestorRepository ancestorRepository;

    @Autowired
    BirthRepository birthRepository;

    @PostMapping(value = "/ancestors")
    public ResponseEntity<Ancestor> postAncestor(@RequestBody Ancestor ancestor) {
        ancestorRepository.save(ancestor);
        return new ResponseEntity<>(ancestor, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ancestors")
    public ResponseEntity<List<Ancestor>> getAncestors() {
        return new ResponseEntity<>(ancestorRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "ancestors/{id}/birth")

    public ResponseEntity<Ancestor> addBirth(
            @PathVariable Long id,
            @RequestBody Long birthId) {
        Ancestor foundAncestor = ancestorRepository.findById(id).get();
        Birth foundBirth = birthRepository.findById(birthId).get();
        foundAncestor.setBirth(foundBirth);
        ancestorRepository.save(foundAncestor);
        return new ResponseEntity<>(foundAncestor, HttpStatus.OK);
    }


}
