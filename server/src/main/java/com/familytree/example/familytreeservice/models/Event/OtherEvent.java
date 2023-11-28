package com.familytree.example.familytreeservice.models.Event;

import com.familytree.example.familytreeservice.models.Event.Event;
import com.familytree.example.familytreeservice.models.Event.EventType;

import java.util.Calendar;

public class OtherEvent extends Event {

    private String eventDescription;

    public OtherEvent(String eventDescription, Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.OTHER;
        this.eventDescription = eventDescription;
    }
}
