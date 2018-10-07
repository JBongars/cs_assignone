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
     * @variable score = the player's accumulated score
     * @variable isCurrentTurn = whether it is the player's current turn
     */
    private int score;
    private boolean isCurrentTurn;

    /**
     * @description constructor
     * @param score
     */
    Player(int score, boolean isCurrentTurn){
        this.score = score;
        this.isCurrentTurn = isCurrentTurn;
    }

    /**
     * @description get the current score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * @description get the
     * @return
     */
    public boolean getCurrentTurn() {
        return isCurrentTurn;
    }

    /**
     * @description get the current turn
     * @param currentTurn
     */
    public void setCurrentTurn(boolean currentTurn) {
        isCurrentTurn = currentTurn;
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
        return "<Player>";
    }
}
