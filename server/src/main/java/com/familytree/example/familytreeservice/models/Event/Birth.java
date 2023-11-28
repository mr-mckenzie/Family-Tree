package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public class Birth extends Event {

    public Birth(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.BIRTH;
    }
}
