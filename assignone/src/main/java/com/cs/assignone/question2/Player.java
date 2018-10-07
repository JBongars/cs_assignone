package com.cs.assignone.question2;

/**
 * @Author: Julien Bongars
 * @Author_id: 234234
 * @Title: Player class for Question 2 of 2 of Assignment 1
 * @Description
 * Player class captures the current state of players in question 2.
 */
class Player {

    /**
     * @variable name = the player's name
     * @variable score = the player's accumulated score
     * @variable isCurrentTurn = whether it is the player's current turn
     */
    private String name;
    private int score;

    /**
     * @description constructor
     * @param name
     */
    Player(String name){
        this.name = name;
        this.score = 0;
    }

    /**
     * @description get the player's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @description get the current score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * @description
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @description manually set the score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @description adds input number of points to score
     * @param points
     */
    public void addScore(int points){
        this.score += points;
    }

    /**
     * @description override toString method for this class
     * @return string "<Player>"
     */
    @Override
    public String toString(){
        return "<Player: " + getName() + ">";
    }
}
