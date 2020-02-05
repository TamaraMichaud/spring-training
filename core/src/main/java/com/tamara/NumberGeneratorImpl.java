package com.tamara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("nameOfMyBean")
@Component
public class NumberGeneratorImpl implements NumberGenerator {

//    fields
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

//    public methods
    @Override
    public int next() {
//        return random.nextInt(maxNumber);
//        e.g. min = 5, max = 20; we want a random number between the two not just below the max
//        20 - 5 = 15; numbers between 0-15 -> + 5; gives 5 - 20
        return random.nextInt((maxNumber - minNumber)) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {return minNumber; }
}
