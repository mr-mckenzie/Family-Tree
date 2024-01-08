package com.familytree.example.familytreeservice.models.Event;

import jakarta.persistence.Entity;

import java.util.Calendar;

@Entity
public class Death extends Event {

    public Death(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.DEATH;
    }

    public Death() {
    }
}
