package com.tamara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("nameOfMyBean")
//@Component  // << using AppConfig @Bean methods rather than @ComponentScan... same-same
public class NumberGeneratorImpl implements NumberGenerator {

//    fields
    private final Random random = new Random();
    @Autowired
    private int maxNumber;

//    public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
