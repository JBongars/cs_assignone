package com.cs.assignone.question1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cs.assignone.dependencies.*;

/**
 * @Author: Julien Bongars
 * @Author_id: 234234
 * @Title: Question 1 of 2 of Assignment 1
 * @Description
 * Program enables user to input multiple survey results for a television rating service.
 * Enables input of gender (m/f) and age over N (declarable).
 * Displays percentages of results. Does not store data
 * @Dependencies csScanner (see documentation included in class)
 */
public class Question1 {

    /**
     * @description: scanner wrapper for fetching easy inputs
     */
    private static csScanner scn = new csScanner();

    public Question1(){ }

    /**
     * @description get the percentage between total number of persons and given filter predicate
     * @param myList = target List of type Person
     * @param cb = cb for filter method call
     * @return percentage float of filter(cb) divided by the total number of persons in myList
     */
    private static float getRatio(List<Person> myList, Predicate<Person> cb){
        return myList.stream().filter(cb).count() * 100 / myList.size();
    }

    /**
     * @description Main Program
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        /**
         * @variable age = temp variable of storing persons's age
         * @variable gender = temp variable of storing person's gender
         * @variable isWatchesShowsRegularly = temp variable for storing whether person watches show regularly
         * @variable isWatchesShowsRegularlyCount = variable for storing the total number of people watching show regularly
         * @variable tUnderN = total percentage under N years of age
         * @variable tOverN = total percentage over N years of age
         * @variable fTotal = total percentage of females
         * @variable fUnderN = total percentage of females under N years of age
         * @variable fOverN = total percentage of females over N years of age
         * @variable mTotal = total percentage of males
         * @variable mUnderN = total percentage of males under N years of age
         * @variable mOverN = total percentage of males over N years of age
         * @constant N = years of age to base research on
         */
        List<Person> persons = new ArrayList<>();
        int age;
        char gender;
        boolean isWatchesShowsRegularly;
        int isWatchesShowsRegularlyCount;

        float tUnderN;
        float tOverN;

        float fTotal;
        float fUnderN;
        float fOverN;

        float mTotal;
        float mUnderN;
        float mOverN;

        final int N = 30;

        /*
         * Main Program
         */

        csUtility.printStudentInfo("Assignment 1 - Question 1");

        while(true){

            /*
             * Prompt user for Persons information
             * Store information in myList
             */
            do {
                age = scn.inputInt("Please enter the person's age (1...110):");
                /*
                 * Checking if person gender was entered as 'm' or 'f'
                 */
                while(true) {
                    gender = scn.inputChar("Please enter the person's gender (M/F):");
                    if(gender == 'm' || gender == 'f'){
                        break;
                    } else {
                        System.out.println("Incorrect Value, please try again");
                    }
                }
                isWatchesShowsRegularly = scn.inputBool("Please enter whether the person watches the show regularly");
                persons.add(new Person(age, gender, isWatchesShowsRegularly));

                /*
                 * Checks whether user wants to add a new person's details. Default value is 'y'
                 */
            } while (scn.inputDefaultBool("Do you want to enter another person's details?", 'y'));

            /*
             * Calculation for various values
             */
            fTotal = getRatio(persons, (elem -> elem.getGender() == 'f'));
            mTotal = getRatio(persons, (elem -> elem.getGender() == 'm'));

            tUnderN = getRatio(persons, (e -> e.getAge() < N));
            tOverN = getRatio(persons, (e -> e.getAge() >= N));

            fUnderN = getRatio(persons, (e -> e.getGender() == 'f' && e.getAge() < N));
            fOverN = getRatio(persons, (e -> e.getGender() == 'f' && e.getAge() >= N));

            mUnderN = getRatio(persons, (e -> e.getGender() == 'm' && e.getAge() < N));
            mOverN = getRatio(persons, (e -> e.getGender() == 'm' && e.getAge() >= N));

            isWatchesShowsRegularlyCount = (int) persons.stream().filter(e -> e.getWatchesShowsRegularly()).count();

            System.out.println("\n\n");
            System.out.println("The total number of people surveyed = " + persons.size());
            System.out.println("The number of people who watch the show regularly = " + isWatchesShowsRegularlyCount);
            System.out.println("The percentage of those who watch the show regularly = " + isWatchesShowsRegularlyCount / persons.size());
            System.out.println("\n\n");

            /*
             * Printing the results
             */
            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Gender    Under %d    %d or Over      Total", N, N));
            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Female    %1$.2f      %2$.2f      %3$.2f", fUnderN, fOverN, fTotal));
            System.out.println(String.format("Male      %1$.2f      %2$.2f      %3$.2f", mUnderN, mOverN, mTotal));
            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Total     %1$.2f      %2$.2f      %3$.2f", tUnderN, tOverN, 100.00));

            System.out.println("\n\n\n");

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
        return "<Question 1>";
    }
}
