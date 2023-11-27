package com.familytree.example.familytreeservice.models;

import java.util.ArrayList;
import java.util.List;

public class Ancestor {

    private String forename;
    private String surname;
    private Gender gender;
    private ArrayList <Event> lifeEvents;

    public Ancestor(String forename, String surname, Gender gender) {
        this.forename = forename;
        this.surname = surname;
        this.gender = gender;
        this.lifeEvents = new ArrayList <Event>();
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Event> getLifeEvents() {
        return lifeEvents;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addLifeEvent(Event lifeEvent){
        lifeEvents.add(lifeEvent);
    }


}
