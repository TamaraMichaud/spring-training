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
        return "RESULT MESSAGE";
    }

    @Override
    public String getMainMessage() {
        return "MAIN MESSAGE";
    }

}
