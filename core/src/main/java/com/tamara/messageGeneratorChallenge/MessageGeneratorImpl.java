package com.tamara.messageGeneratorChallenge;

import com.tamara.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl  implements MessageGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private GameImpl game;
    private int guessCount = 10;

    @PostConstruct
    public void shutDownMethod(){
        LOGGER.info("Game object created well by autowiring? (should not be null ->): {}", this.game);
        LOGGER.info("Starting automatically via PostConstruct");
    }



    @Override
    public String getResultMessage() {

        LOGGER.info("Used method getResultMessage()");

        if(game.getRemaining() == guessCount) {
            return "Take your first guess: ";
        }

        if(!game.isValidNumberRange()) {
            return "Not a valid number...";
        }

        return (game.isGameWon()) ? "Woop yeah!" : "Pah-ha, no mate..." + " Number was " + game.getNumber();
    }

    @Override
    public String getMainMessage() {
        return "MAIN MESSAGE";
    }

}
