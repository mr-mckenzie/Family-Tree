package com.familytree.example.familytreeservice.controllers;

import com.familytree.example.familytreeservice.models.Event.Birth;
import com.familytree.example.familytreeservice.repositories.BirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BirthController {

    @Autowired
    BirthRepository birthRepository;

    @PostMapping(value = "/births")
    public ResponseEntity<Birth> postBirth(@RequestBody Birth birth) {
        birthRepository.save(birth);
        return new ResponseEntity<>(birth, HttpStatus.CREATED);
    }

    @GetMapping(value = "/births")
    public ResponseEntity<List<Birth>> getBirths() {
        return new ResponseEntity<>(birthRepository.findAll(), HttpStatus.OK);
    }

}
