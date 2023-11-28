package com.familytree.example.familytreeservice.models.Event;

import java.util.Calendar;

public class Death extends Event {

    public Death(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.DEATH;
    }
}
