package com.familytree.example.familytreeservice.models.Event;

import jakarta.persistence.*;

import java.util.Calendar;

//@Entity
//@Table(name = "Event")
public abstract class Event implements Comparable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column(name = "type")
    EventType type;
//    @Column(name = "date")
    private Calendar date;
//    @Column(name = "location")
    private String location;
//    @Column(name = "citation")
    private String citation;

    public Event(Calendar date, String location, String citation) {
        this.date = date;
        this.location = location;
        this.citation = citation;
    }

//    public Event() {
//    }

    public EventType getType() {
        return type;
    }

    public Calendar getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getCitation() {
        return citation;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Event) obj).getDate().equals(getDate());
    }

    @Override
    public int compareTo(Object o) {
        Event e = (Event) o;
        return getDate().compareTo(e.getDate());
    }
}
