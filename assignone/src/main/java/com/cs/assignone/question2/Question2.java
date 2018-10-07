package com.cs.assignone.question2;

import com.cs.assignone.dependencies.csScanner;

/**
 * @Author: Julien Bongars
 * @Author_id: 234234
 * @Title: Question 2 of 2 of Assignment 1
 * @Description
 * Program is simple hangman game played by two people
 * First person will think of a word and insert it into the program
 * Second person will attempt to guess the work
 * Program will display hints including characters that were already previous guessed and unknown characters as '?'
 * Program will display total wrong number of guesses
 * @Dependencies csScanner (see documentation included in class)
 */
public class Question2 {

    public void Question2() { }

    private static csScanner scn = new csScanner();

    public static void main(String[] arg){
        /**
         * @variable scn
         */

        /**
         * Main Program
         */
        while(true){




            /**
             * Prompt to restart program. Default value is 'n'
             */
            System.out.println(scn.inputDefaultBool("Would you like to restart?", 'n'));
            if(!scn.inputDefaultBool("Would you like to restart?", 'n')){
                break;
            }
        }
        System.out.println("End of Program...");

    }

}
