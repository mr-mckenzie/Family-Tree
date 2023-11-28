package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public abstract class Event {
    EventType type;
    private Calendar date;
    private String location;
    private String citation;

    public Event(Calendar date, String location, String citation) {
        this.date = date;
        this.location = location;
        this.citation = citation;
    }

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
}
