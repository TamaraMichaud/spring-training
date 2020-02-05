package com.tamara.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess_2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleNumberGuess_2.class);

    @EventListener
    public void startMethod(ContextRefreshedEvent contextRefreshedEvent){
        LOGGER.info("EG2: same as the _1 but by annotations alone");
    }
}
