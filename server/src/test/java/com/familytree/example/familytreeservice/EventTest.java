package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Event.Birth;
import com.familytree.example.familytreeservice.models.Event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    public Event birth;
    public Calendar birthday;

    @BeforeEach
    public void setUp() {
        birthday = Calendar.getInstance();
        birthday.set(1759, Calendar.JANUARY,25);
        birth = new Birth(birthday, "Alloway, Ayrshire, Scotland", "National Records of Scotland, Old Parish Register for Ayr");
    }

    @Test
    public void hasType() {
        assertEquals("Birth", birth.getType());
    }

    @Test
    public void hasDate() {
        Calendar eventDate = birth.getDate();
        assertEquals(birthday, eventDate);
        assertEquals(25, eventDate.get(Calendar.DATE));
        assertEquals(Calendar.JANUARY, eventDate.get(Calendar.MONTH));
        assertEquals(1759, eventDate.get(Calendar.YEAR));
    }

    @Test
    public void hasLocation() {
        assertEquals("Alloway, Ayrshire, Scotland", birth.getLocation());
    }

    @Test
    public void hasCitation() {
        assertEquals("National Records of Scotland, Old Parish Register for Ayr", birth.getCitation());
    }

}
