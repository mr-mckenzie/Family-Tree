package com.familytree.example.familytreeservice.controllers;

import com.familytree.example.familytreeservice.models.Event.Death;
import com.familytree.example.familytreeservice.repositories.DeathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeathController {

    @Autowired
    DeathRepository deathRepository;

    @PostMapping(value = "/deaths")
    public ResponseEntity<Death> postDeath(@RequestBody Death death) {
        deathRepository.save(death);
        return new ResponseEntity<>(death, HttpStatus.CREATED);
    }

    @GetMapping(value = "/deaths")
    public ResponseEntity<List<Death>> getDeaths() {
        return new ResponseEntity<>(deathRepository.findAll(), HttpStatus.OK);
    }

}
