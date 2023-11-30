package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public abstract class Event implements Comparable {
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
