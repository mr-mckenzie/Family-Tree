package com.familytree.example.familytreeservice.models.Event;

public enum EventType {
    BIRTH("Birth"),
    MARRIAGE("Marriage"),
    CENSUS("Census"),
    DEATH("Death"),
    OTHER("Other");

    private final String event;

    EventType(String event) {
        this.event = event;
    }

}
