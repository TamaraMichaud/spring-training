package com.tamara;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game {

    // constants
    private static final Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

    // fields
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // constructor-based dependency injection
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // private methods

    private void checkValidNumberRange(){
        this.validNumberRange = (this.guess >= this.smallest) && (this.guess <= this.biggest);
    }


    // public methods

    @Override
    public void reset() {
        this.smallest = 0;
        this.guess = 0;
        this.remainingGuesses = guessCount;
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        LOGGER.debug("Number chosen is {}", this.number);
    }
    // ^^ START / RESTART the game


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
        remainingGuesses--;

    }





    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getGuess() {
        return this.guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemaining() {
        return this.remainingGuesses;
    }

    @Override
    public boolean isValidNumberRange() {
        return this.validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return this.guess == this.number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }
}
