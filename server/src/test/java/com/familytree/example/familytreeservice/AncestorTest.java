package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.models.Event;
import com.familytree.example.familytreeservice.models.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class AncestorTest {

    public Ancestor ancestor;

    @BeforeEach
    public void setUp() {
        ancestor = new Ancestor("Robert", "Bruce", Gender.MALE);
    }

    @Test
    public void hasForename(){
        assertEquals("Robert", ancestor.getForename());
    }

    @Test
    public void hasSurname(){
        assertEquals("Bruce", ancestor.getSurname());
    }

    @Test
    public void hasGender(){
        assertEquals(Gender.MALE, ancestor.getGender());
        assertEquals("Male", ancestor.getGender().getGender());
    }

}
