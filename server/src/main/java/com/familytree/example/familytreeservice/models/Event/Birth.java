package com.familytree.example.familytreeservice.models.Event;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Calendar;


@Entity
public class Birth extends Event {

    public Birth(Calendar date, String location, String citation) {
        super(date, location, citation);
        this.type = EventType.BIRTH;
    }

    public Birth() {
    }
}
