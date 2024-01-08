package com.familytree.example.familytreeservice.models.Event;

import jakarta.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "events")
public abstract class Event implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    EventType type;
    @Column(name = "date")
    private Calendar date;
    @Column(name = "location")
    private String location;
    @Column(name = "citation")
    private String citation;

    public Event(Calendar date, String location, String citation) {
        this.date = date;
        this.location = location;
        this.citation = citation;
    }

    public Event() {
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
