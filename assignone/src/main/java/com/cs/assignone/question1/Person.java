package com.cs.assignone.question1;

import java.util.List;

class Person {
    private int age;
    private char gender;
    private boolean isWatchesShowsRegularly;

    public Person(int age, char gender, boolean isWatchesShowsRegularly){
        this.age = age;
        this.gender = gender;
        this.isWatchesShowsRegularly = isWatchesShowsRegularly;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public boolean getIsWatchesShowsRegularly() {
        return isWatchesShowsRegularly;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setWatchesShowsRegularly(boolean watchesShowsRegularly) {
        isWatchesShowsRegularly = watchesShowsRegularly;
    }

    @Override
    public String toString(){
        return "<Person>";
    }
}
