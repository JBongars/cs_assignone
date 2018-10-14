package com.cs.assignone.question2;

import com.cs.assignone.dependencies.csScanner;
import com.cs.assignone.dependencies.csUtility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        boolean isPlaying = true;
        int playerTurn = 1;
        Game session;
        Player currentPlayer;
        List<Player> players = new ArrayList<>();

        csUtility.printStudentInfo("Assignment 1 - Question 2");

        /*
         * Main Program
         */
        while(true){

            /*
             * Get Player information
             */
            do {
                players.add(new Player(scn.inputStr("Enter player name:")));
            } while(players.size() < 2 || scn.inputDefaultBool("Add new player?", 'n'));

            /*
             * Get first player to enter secret phrase (other players will have a turn later on...
             */
            do {
                for (int i = 0; i < players.size(); i++) {
                    session = new Game(scn.inputStr(players.get(i).getName() + ", please enter the secret phrase:").toLowerCase());

                    /*
                     * Clear the screen
                     */
                    csUtility.clearScreen();

                    /*
                     * While the game state is not win, give players a chance to guess
                     */
                    while (!session.getWinFlag()) {
                        for (int j = 0; j < players.size(); j++) {
                            if (i == j) continue; // player who gave secret phrase should not be allowed to guess
                            currentPlayer = players.get(j);

                            /*
                             * Displays the phrase mask as ???
                             */
                            System.out.println(session.getPhrase());
                            System.out.println();

                            /*
                             * Guesses can either be letters or whole phrases
                             */
                            currentPlayer.addScore(session.makeGuess(scn.inputStr(currentPlayer.getName() + " please enter a guess:")));
                            players.set(j, currentPlayer);
                        }
                    }
                    System.out.println("\nGame has been won!\n\n");
                }
                /*
                 * Ask would the players like to play another game.
                 */
            } while(scn.inputDefaultBool("Would you like to play another game?", 'y'));

            /*
             * Scores are tallied up and displayed in descending order
             */
            players.sort(Comparator.comparing(Player::getScore, Comparator.reverseOrder()));

            System.out.println(String.format("\n\n%s has won the game! \n\n\n", players.get(0).getName()));
            System.out.println("-------------------------------");
            System.out.println("Player      | Score");
            System.out.println("-------------------------------");
            for(Player i: players){
                System.out.println(String.format("%1$s     | %2$d", i.getName(), i.getScore()));
            }
            System.out.println("-------------------------------");

            /*
             * Prompt to restart program. Default value is 'n'
             */
            if(!scn.inputDefaultBool("Would you like to restart?", 'n')){
                break;
            }
        }
        System.out.println("End of Program...");

    }

    @Override
    public String toString(){
        return "<Question 2>";
    }
}
