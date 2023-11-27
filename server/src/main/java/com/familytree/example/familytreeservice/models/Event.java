package com.familytree.example.familytreeservice.models;

import java.util.Calendar;
import java.util.Date;

public class Event {
    private String type;
    private Calendar date;
    private String location;
    private String citation;

    public Event(String type, Calendar date, String location, String citation) {
        this.type = type;
        this.date = date;
        this.location = location;
        this.citation = citation;
    }

    public String getType() {
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
