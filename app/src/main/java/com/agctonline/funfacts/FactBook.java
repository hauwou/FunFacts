package com.agctonline.funfacts;

import java.util.Random;

//added text

public class FactBook {


    public String getArrayFact() {


        String[] mFacts = {
                "array Fact 1",
                "array Fact 2",
                "array Fact 3",
                "array Fact 4",
                "array Fact 5"};

        Random randomGenerator = new Random();
        int randomNumberFromArray = randomGenerator.nextInt(mFacts.length);
        return mFacts[randomNumberFromArray];

    }

}
