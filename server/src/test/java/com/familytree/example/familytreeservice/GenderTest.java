package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenderTest {

    @Test
    public void canCreateMale() {
        Gender male = Gender.MALE;
        assertEquals("Male", male.getGender());
    }

    @Test
    public void canCreateFemale() {
        Gender female = Gender.FEMALE;
        assertEquals("Female", female.getGender());
    }
}
