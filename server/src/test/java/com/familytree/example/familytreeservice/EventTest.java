package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    public Event birth;
    public Date birthday;

    @BeforeEach
    public void setUp() {
        birthday = new Date(1759,1,25);
        birth = new Event("Birth", birthday, "Alloway, Ayrshire, Scotland", "National Records of Scotland, Old Parish Register for Ayr");
    }

    @Test
    public void hasType() {
        assertEquals("Birth", birth.getType());
    }

    @Test
    public void hasDate() {
        Date eventDate = birth.getDate();
        assertEquals(birthday, eventDate);
        assertEquals(25, eventDate.getDate());
        assertEquals(1, eventDate.getMonth());
        assertEquals(1759, eventDate.getYear());
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
