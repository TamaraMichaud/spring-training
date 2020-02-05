package com.tamara;

public interface Game {

    int getNumber();
    int getGuess();
    void setGuess(int guess);
    int getGuessCount();
    int getSmallest();
    int getBiggest();
    int getRemaining();
    void reset();
    void check();
    boolean isValidNumberRange();
    boolean isGameWon();
    boolean isGameLost();
}
