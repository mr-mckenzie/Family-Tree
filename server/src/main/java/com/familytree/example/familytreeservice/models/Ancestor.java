package com.familytree.example.familytreeservice.models;

import com.familytree.example.familytreeservice.models.Event.Birth;
import com.familytree.example.familytreeservice.models.Event.Death;
import com.familytree.example.familytreeservice.models.Event.Event;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

@Entity
@Table(name = "ancestors")
public class Ancestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "forename")
    private String forename;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private Gender gender;
//    @ManyToMany(mappedBy = "ancestor_id")
//    @JsonIgnoreProperties({"ancestor_id"})
//    private ArrayList <Event> lifeEvents;
    @OneToOne
    @JoinColumn(name = "birth_id")
    private Birth birth;
//    @OneToOne
//    @JoinColumn(name = "death_id")
//    @JsonIgnoreProperties("deceased_id")
//    private Death death;

//    @ManyToOne
//    @JoinColumn(name = "father_id")
//    private Ancestor father;

//    @ManyToOne
//    @JoinColumn(name = "mother_id")
//    private Ancestor mother;
//    @OneToMany(mappedBy = "id")
//    @JsonIgnoreProperties("id")
//    private ArrayList<Ancestor> spouses;
//    @OneToMany(mappedBy = "id")
//    @JsonIgnoreProperties("id")
//    private ArrayList<Ancestor> children;

    public Ancestor(String forename, String surname, Gender gender) {
        this.forename = forename;
        this.surname = surname;
        this.gender = gender;
//        this.lifeEvents = new ArrayList<>();
//        this.spouses = new ArrayList<>();
//        this.children = new ArrayList<>();
        this.birth = null;
//        this.death = null;
    }

    public Ancestor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

//    public ArrayList<Event> getLifeEvents() {
//        return lifeEvents;
//    }
//    public void addLifeEvent(Event lifeEvent){
//        lifeEvents.add(lifeEvent);
//        Collections.sort(lifeEvents);
//    }

//    public Ancestor getFather() {
//        return father;
//    }

//    public void setFather(Ancestor father) {
//        if (father.getGender() == Gender.MALE) {
//            this.father = father;
//        } else {
//            System.out.println("Error, attempting to add female father. Did you mean to add a mother?");
//        }
//    }

//    public Ancestor getMother() {
//        return mother;
//    }

//    public void setMother(Ancestor mother) {
//        if (mother.getGender() == Gender.FEMALE){
//            this.mother = mother;
//        } else {
//            System.out.println("Error, attempting to add male mother. Did you mean to add a father?");
//        }
//
//    }

//    public ArrayList<Ancestor> getSpouses() {
//        return spouses;
//    }

//    public void addSpouse(Ancestor spouse) {
//        if (!this.spouses.contains(spouse)){
//            this.spouses.add(spouse);
//        } else {
//            System.out.println("Warning, spouse already added.");
//        }
//    }

//    public ArrayList<Ancestor> getChildren() {
//        return children;
//    }

//    public void addChild(Ancestor child) {
//        this.children.add(child);
//    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

//    public Death getDeath() {
//        return death;
//    }

//    public void setDeath(int date, int month, int year) {
//        Calendar deathDate = Calendar.getInstance();
//        deathDate.set(year, month-1, date, 0, 0, 0);
//        deathDate.set(Calendar.MILLISECOND, 0);
//        this.death = new Death(deathDate,null, null);
//    }

//    public int getAge(int date, int month, int year){
//        int age = -1;
//        if (birth != null) {
//            Calendar birthDate = getBirth().getDate();
//            Calendar comparisonDate = Calendar.getInstance();
//            Calendar ageCal = comparisonDate;
//            comparisonDate.set(year, (month - 1), (date+1), 0, 0, 0);
//            comparisonDate.set(Calendar.MILLISECOND, 0);
//            comparisonDate.add(Calendar.DATE, - birthDate.get(Calendar.DATE));
//            comparisonDate.add(Calendar.MONTH, - birthDate.get(Calendar.MONTH));
//            comparisonDate.add(Calendar.YEAR, - birthDate.get(Calendar.YEAR));
//
////            System.out.println("year is " + comparisonDate.get(Calendar.YEAR)+ " comparison month is " + comparisonDate.get(Calendar.MONTH) + " comparison date is " + comparisonDate.get(Calendar.DATE) + " ERA is " + comparisonDate.get(Calendar.ERA));
//            if (comparisonDate.get(Calendar.ERA) > 0) {
//                age = comparisonDate.get(Calendar.YEAR);
//            }
//        }
//        return age;
//    }


}
