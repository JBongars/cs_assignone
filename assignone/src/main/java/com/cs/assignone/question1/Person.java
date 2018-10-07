package com.cs.assignone.question1;

import java.util.List;

/**
 * @Author: Julien Bongars
 * @Author_id: 234234
 * @Title: Person object for Question 1 of 2 of Assignment 1
 * @Description
 * Person Class for survey results in question 1. Note that this class is not public
 */
class Person {
    private int age;
    private char gender;
    private boolean isWatchesShowsRegularly;

    /**
     * @Title Constructor
     * @param age
     * @param gender
     * @param isWatchesShowsRegularly
     */
    public Person(int age, char gender, boolean isWatchesShowsRegularly){
        this.age = age;
        this.gender = gender;
        this.isWatchesShowsRegularly = isWatchesShowsRegularly;
    }

    /**
     * @Title get age
     * @return this.age
     */
    public int getAge() {
        return age;
    }

    /**
     * @Title get gender
     * @return this.gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @Title get isWatchesShowsRegularly
     * @return this.isWatchesShowsRegularly
     */
    public boolean getIsWatchesShowsRegularly() {
        return isWatchesShowsRegularly;
    }

    /**
     * @Title Sets this.age
     * @param age
     * @return void
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @Title Sets this.gender
     * @param gender
     * @return void
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @Title Sets this.watchesShowsRegularly
     * @param watchesShowsRegularly
     * @return void
     */
    public void setWatchesShowsRegularly(boolean watchesShowsRegularly) {
        isWatchesShowsRegularly = watchesShowsRegularly;
    }

    /**
     * @Title Override toString function for printing class
     * @return String
     */
    @Override
    public String toString(){
        return "<Person>";
    }
}
