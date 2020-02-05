package com.tamara;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("nameOfMyBean")
@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

//    fields
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();
//    @Autowired
//    @MaxNumber
    private final int maxNumber; // << "final" is good practice with constructor injection

//    @Autowired
//    @MinNumber
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //    public methods
    @Override
    public int next() {
//        return random.nextInt(maxNumber);
//        e.g. min = 5, max = 20; we want a random number between the two not just below the max
//        20 - 5 = 15; numbers between 0-15 -> + 5; gives 5 - 20
        return random.nextInt((maxNumber - minNumber)) + minNumber;
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() {return minNumber; }
}
