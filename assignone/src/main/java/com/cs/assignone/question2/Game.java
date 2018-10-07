package com.cs.assignone.question2;


/**
 * @Author: Julien Bongars
 * @Author_id: 234234
 * @Title: Game class for Question 2 of 2 of Assignment 1
 * @Description
 * Game class enables program to start new game. Game state is containerized for easy initialization.
 */
class Game {

    /**
     * @variable secret = the secret phrase
     * @variable guesses = guesses made throughout the game
     * @variable wrongAnswerCount = number of wrong guesses made throughout the game
     */
    private String secret;
    private String guesses;
    private int wrongAnswerCount;

    /**
     * @description constructor
     * @param secret
     */
    public Game (String secret){
        this.secret = secret;
        this.guesses = "";
        this.wrongAnswerCount = 0;
    }

    /**
     * @description Makes a guess on the phrase, if wrong answer, increments wrongAnswerCount
     * @param guess
     * @mutates wrongAnswerCount
     * @return score for the turn
     */
    public int makeGuess(char guess){
        int score = 0; //init score as 0

        for(char i: guesses.toCharArray()){
            if(i == guess){
                System.out.println("You have already guessed that character!");
            } else {
                this.guesses += guess;
                if(secret.indexOf(guess) < 0){
                    wrongAnswerCount++;
                } else {
                    score = 1;
                }
            }
        }
        return score;
    }

    /**
     * @description Returns the phrase excluding all previous guesses
     * @return phrase derived from this.secret
     */
    public String getPhrase(){
        String result = secret;
        return result.replaceAll("[^" + guesses + "]", "?");
    }

    /**
     * @description get the secret
     * @return this.secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @description get the wrong answer count
     * @return this.wrongAnswerCount
     */
    public int getWrongAnswerCount() {
        return wrongAnswerCount;
    }

    /**
     * @description set the secret for the game
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @description override toString method for this class
     * @return string "<Game>"
     */
    @Override
    public String toString(){
        return "<Game>";
    }


}
