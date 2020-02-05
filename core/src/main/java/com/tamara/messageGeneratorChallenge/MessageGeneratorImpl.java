package com.tamara.messageGeneratorChallenge;

import com.tamara.GameImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl  implements MessageGenerator {

//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);
//    ^^ using lombok @Slf4j annotation the object is called "log"

    @Autowired
    private GameImpl game;

    @PostConstruct
    public void shutDownMethod(){
        log.info("Game object created well by autowiring? (should not be null ->): {}", this.game);
        log.info("Starting automatically via PostConstruct");
    }

    @Override
    public String getResultMessage() {

        log.info("Used method getResultMessage()");

        if(game.getRemaining() == game.getGuessCount()) {
            return "Take your first guess: ";
        }

        if(!game.isValidNumberRange()) {
            return "Not a valid number...";
        }

        if(game.isGameWon()) {
            return "Congratulations!!  You guessed right, it was " + game.getNumber();
        }
        String guessAgain = "Nope, go ";
        if(game.getGuess() < game.getNumber()) {
            guessAgain += "higher...";
        } else {
            guessAgain += "lower... ";
        }
        return guessAgain + String.format("  [You have %d guesses left]", game.getRemaining());
    }

    @Override
    public String getMainMessage() {
        return "--- Welcome!  How to play... guess a number between " + game.getSmallest()
                + " and " + game.getBiggest() + "! --- ";
    }

}
