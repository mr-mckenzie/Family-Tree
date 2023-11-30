package com.familytree.example.familytreeservice;

import com.familytree.example.familytreeservice.models.Ancestor;
import com.familytree.example.familytreeservice.models.Event.*;
import com.familytree.example.familytreeservice.models.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;

public class AncestorTest {

    public Ancestor robertBurns;
    public Ancestor wife;
    public Ancestor mother;
    public Ancestor father;
    public Calendar marriageDate;
    public Calendar firstChildDate;

    @BeforeEach
    public void setUp() {
        robertBurns = new Ancestor("Robert", "Burns", Gender.MALE);
        wife = new Ancestor("Jean", "Armour", Gender.FEMALE);
        mother = new Ancestor("Agnes", "Broun", Gender.FEMALE);
        father = new Ancestor("William", "Burnes", Gender.MALE);

        marriageDate = Calendar.getInstance();
        marriageDate.set(1788, Calendar.AUGUST, 5, 0 ,0 ,0);
        marriageDate.set(Calendar.MILLISECOND, 0);

        firstChildDate = Calendar.getInstance();
        firstChildDate.set(1785, Calendar.MAY, 22, 0 ,0 ,0);
        firstChildDate.set(Calendar.MILLISECOND, 0);

    }

    @Test
    public void hasForename(){
        assertEquals("Robert", robertBurns.getForename());
    }

    @Test
    public void hasSurname(){
        assertEquals("Burns", robertBurns.getSurname());
    }

    @Test
    public void hasGender(){
        assertEquals(Gender.MALE, robertBurns.getGender());
        assertEquals("Male", robertBurns.getGender().getGender());
    }

    @Test
    public void birthStartsNull(){
        assertNull(robertBurns.getBirth());
    }

    @Test
    public void hasBirthDate(){
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1759, Calendar.JANUARY, 25, 0, 0, 0);
        birthDate.set(Calendar.MILLISECOND, 0);
        robertBurns.setBirth(25, 1, 1759);
        Birth retrievedBirthday = robertBurns.getBirth();
        assertEquals(birthDate, retrievedBirthday.getDate());
        assertEquals(25, retrievedBirthday.getDate().get(Calendar.DATE));
        assertEquals(Calendar.JANUARY, retrievedBirthday.getDate().get(Calendar.MONTH));
        assertEquals(1759, retrievedBirthday.getDate().get(Calendar.YEAR));
    }

    @Test
    public void deathStartsNull(){
        assertNull(robertBurns.getDeath());
    }

    @Test
    public void hasDeathDate(){
        Calendar deathDate = Calendar.getInstance();
        deathDate.set(1796, Calendar.JULY, 21, 0, 0, 0);
        deathDate.set(Calendar.MILLISECOND, 0);
        robertBurns.setDeath(21, 7, 1796);
        Death retrievedDeath = robertBurns.getDeath();
        assertEquals(deathDate, retrievedDeath.getDate());
        assertEquals(21, retrievedDeath.getDate().get(Calendar.DATE));
        assertEquals(Calendar.JULY, retrievedDeath.getDate().get(Calendar.MONTH));
        assertEquals(1796, retrievedDeath.getDate().get(Calendar.YEAR));
    }

    @Test
    public void lifeEventsStartsEmpty(){
        assertEquals(0, robertBurns.getLifeEvents().size());
    }

    @Test
    public void canAddLifeEvent() {
        Marriage marriage = new Marriage(marriageDate, "Mauchline, Ayrshire, Scotland", "OPR");
        robertBurns.addLifeEvent(marriage);
        assertEquals(marriage, robertBurns.getLifeEvents().get(0));
    }

    @Test
    public void multipleLifeEventsSortedChronologically() {
        Marriage marriage = new Marriage(marriageDate, "Mauchline, Ayrshire, Scotland", "OPR");
        OtherEvent child = new OtherEvent("Birth of Child", firstChildDate, "Ayrshire, Scotland", "OPR");
        robertBurns.addLifeEvent(marriage);
        robertBurns.addLifeEvent(child);
        assertEquals(2, robertBurns.getLifeEvents().size());
        assertEquals(child, robertBurns.getLifeEvents().get(0));
    }


    @Test
    public void canChangeForename() {
        robertBurns.setForename("William");
        assertEquals("William", robertBurns.getForename());
    }

    @Test
    public void canChangeSurname() {
        robertBurns.setSurname("Wallace");
        assertEquals("Wallace", robertBurns.getSurname());
    }

    @Test
    public void canChangeGender() {
        robertBurns.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, robertBurns.getGender());
    }

    @Test
    public void canAddFather() {
        robertBurns.setFather(father);
        assertEquals(father, robertBurns.getFather());
    }

    @Test
    public void canAddFather__failWrongGender() {
        robertBurns.setFather(mother);
        assertNull(robertBurns.getFather());
    }

    @Test
    public void canAddMother() {
        robertBurns.setMother(mother);
        assertEquals(mother, robertBurns.getMother());
    }

    @Test
    public void canAddMother__failWrongGender() {
        robertBurns.setMother(father);
        assertNull(robertBurns.getMother());
    }

    @Test
    public void canAddSpouse(){
        robertBurns.addSpouse(wife);
        assertEquals(wife, robertBurns.getSpouses().get(0));
    }

    @Test
    public void canAddMultipleSpouses(){
        Ancestor anotherWife = new Ancestor("Anne", "Other", Gender.FEMALE);
        robertBurns.addSpouse(wife);
        robertBurns.addSpouse(anotherWife);
        assertEquals(2, robertBurns.getSpouses().size());
    }

    @Test
    public void cannotAddSameSpouseTwice() {
        robertBurns.addSpouse(wife);
        robertBurns.addSpouse(wife);
        assertEquals(1, robertBurns.getSpouses().size());
    }

    @Test
    public void canAddChildren() {
        Ancestor son = new Ancestor("James Glencairn", "Burns", Gender.MALE);
        Ancestor daughter = new Ancestor("Elizabeth", "Burns", Gender.FEMALE);
        robertBurns.addChild(daughter);
        robertBurns.addChild(son);
        assertEquals(daughter, robertBurns.getChildren().get(0));
        assertEquals(2, robertBurns.getChildren().size());
        assertEquals(son, robertBurns.getChildren().get(1));
    }

    @Test
    public void canGetAge__dayOfBirthday() {
        robertBurns.setBirth(25, 1, 1759);
        int age = robertBurns.getAge(25, 1, 1790);
        assertEquals(31, age);
    }

    @Test
    public void canGetAge__dayBeforeBirthday() {
        robertBurns.setBirth(25, 1, 1759);
        int age = robertBurns.getAge(24, 1, 1790);
        assertEquals(30, age);
    }

    @Test
    public void canGetAge__manyYearsIntoFuture() {
        robertBurns.setBirth(25, 1, 1759);
        int age = robertBurns.getAge(29, 11, 2023);
        assertEquals(264, age);
    }

    @Test
    public void canGetAge__notYetBorn() {
        robertBurns.setBirth(25, 1, 1759);
        int age = robertBurns.getAge(25, 1, 1725);
        assertEquals(-1, age);
    }

}
