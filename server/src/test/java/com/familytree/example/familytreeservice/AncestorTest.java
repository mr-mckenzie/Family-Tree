package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.models.Event;
import com.familytree.example.familytreeservice.models.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;

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

    @Test
    public void lifeEventsStartsEmpty(){
        assertEquals(0, ancestor.getLifeEvents().size());
    }

    @Test
    public void canAddEvent(){
        Calendar deathDate = Calendar.getInstance();
        deathDate.set(7, Calendar.JUNE, 1329);
        Event death = new Event("Coronation", deathDate, "Dunbartonshire, Scotland", "National Records of Scotland");
        ancestor.addLifeEvent(death);
        assertEquals(death, ancestor.getLifeEvents().get(0));
    }

    @Test
    public void canChangeForename() {
        ancestor.setForename("James");
        assertEquals("James", ancestor.getForename());
    }

    @Test
    public void canChangeSurname() {
        ancestor.setSurname("Burns");
        assertEquals("Burns", ancestor.getSurname());
    }

    @Test
    public void canChangeGender() {
        ancestor.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, ancestor.getGender());
    }

}
