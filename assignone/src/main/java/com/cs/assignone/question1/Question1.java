package com.cs.assignone.question1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.cs.assignone.dependencies.*;


public class Question1 {

    private static wsScanner scn = new wsScanner();

    Question1(){ }

    private static float getRatio(List<Person> myList, Predicate<Person> cb){
        return myList.stream().filter(cb).count() * 100 / myList.size();
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        int age;
        char gender;
        boolean isWatchesShowsRegularly;

        float tUnderN;
        float tOverN;

        float fTotal;
        float fUnderN;
        float fOverN;

        float mTotal;
        float mUnderN;
        float mOverN;

        final int N = 30;

        while(true){

            do {
                age = scn.inputInt("Please enter the person's age (1...110):");
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

            } while (scn.inputDefaultBool("Do you want to enter another person's details?", 'y'));

            fTotal = getRatio(persons, (elem -> elem.getGender() == 'f'));
            mTotal = getRatio(persons, (elem -> elem.getGender() == 'm'));

            tUnderN = getRatio(persons, (e -> e.getAge() < N));
            tOverN = getRatio(persons, (e -> e.getAge() >= N));

            fUnderN = getRatio(persons, (e -> e.getGender() == 'f' && e.getAge() < N));
            fOverN = getRatio(persons, (e -> e.getGender() == 'f' && e.getAge() >= N));

            mUnderN = getRatio(persons, (e -> e.getGender() == 'm' && e.getAge() < N));
            mOverN = getRatio(persons, (e -> e.getGender() == 'm' && e.getAge() >= N));

            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Gender    Under %d    %d or Over      Total", N, N));
            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Female    %1$.2f      %2$.2f      %3$.2f", fUnderN, fOverN, fTotal));
            System.out.println(String.format("Male      %1$.2f      %2$.2f      %3$.2f", mUnderN, mOverN, mTotal));
            System.out.println("---------------------------------------------------------");
            System.out.println(String.format("Total     %1$.2f      %2$.2f      %3$.2f", tUnderN, tOverN, 100.00));

            System.out.println("\n\n\n");

            System.out.println(scn.inputDefaultBool("Would you like to restart?", 'n'));
            if(!scn.inputDefaultBool("Would you like to restart?", 'n')){
                System.out.println("hit 1");
                break;
            }
            System.out.println("hit 2");
        }

        System.out.println("hit!");

    }

}
