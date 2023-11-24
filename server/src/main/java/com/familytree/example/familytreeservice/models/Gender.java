package com.familytree.example.familytreeservice.models;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String gender;

    Gender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }
}
