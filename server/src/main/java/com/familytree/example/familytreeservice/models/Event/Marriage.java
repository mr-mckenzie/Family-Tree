package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public class Marriage extends Event {
    public Marriage(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.MARRIAGE;
    }
}
