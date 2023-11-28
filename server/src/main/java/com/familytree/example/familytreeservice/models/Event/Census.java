package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public class Census extends Event{

    public Census(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.CENSUS;
    }
}
