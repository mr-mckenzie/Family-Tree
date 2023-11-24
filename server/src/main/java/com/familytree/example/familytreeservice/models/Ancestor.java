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
}
