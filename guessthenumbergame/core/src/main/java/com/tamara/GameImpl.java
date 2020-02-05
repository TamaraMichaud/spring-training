package com.tamara;

import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Data
@Getter
@Component
public class GameImpl implements Game {

    // constants
    private static final Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

    // fields
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private int guessCount;

    // vv these three with lombok annotations instead of all the commented
    //     getters and setters down below...
//    private boolean gameWon;
//    private int remaining;
//    private boolean gameLost;

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remaining;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        this.smallest =
                this.guess = numberGenerator.getMinNumber();
        this.remaining = guessCount;
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        LOGGER.debug("Number chosen is {}", this.number);
    }
    // ^^ START / RESTART the game


    @PreDestroy
    public void end(){
        LOGGER.info("in-game preDestroy()");
    }



//    constructor(s)

//ALT1    // constructor-based dependency injection
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    //ALT2    // setter-based dependency injection
//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
//    ^^ now superceded by @Autowired annotation


    // private methods

    private void checkValidNumberRange(){
        this.validNumberRange = (this.guess >= this.smallest) && (this.guess <= this.biggest);
    }


    // public methods

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange) {
            if(guess > number) {
                this.biggest = guess - 1; // << we have guessed too high... so we block any guesses that are equal to or higher.
            }
            if(guess < number) {
                this.smallest = guess + 1; //
            }
        }
        remaining--;

    }


// replaced with lombok annotations
//    @Override
//    public int getNumber() {
//        return this.number;
//    }
//
//    @Override
//    public int getGuess() {
//        return this.guess;
//    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

//    @Override
//    public int getGuessCount() {
//        return this.guessCount;
//    }
//
//    @Override
//    public int getSmallest() {
//        return this.smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return this.biggest;
//    }
//
//    @Override
//    public int getRemaining() {
//        return this.remainingGuesses;
//    }
//
//    @Override
//    public boolean isValidNumberRange() {
//        return this.validNumberRange;
//    }

    @Override
    public boolean isGameWon() {
        return this.guess == this.number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remaining <= 0;
    }
}
