package com.tamara.console;

import com.tamara.Game;
import com.tamara.messageGeneratorChallenge.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess_2 {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleNumberGuess_2.class);

    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess_2(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
//    public void startMethod(ContextRefreshedEvent contextRefreshedEvent){
    public void startMethod() {
        log.info("EG2: same as the _1 but by annotations alone");

        // this is the actual game.  starts on startup...

        Scanner scanner = new Scanner(System.in);  // input interface
        // infinite loop until player wins, loses or quits
        System.out.println(messageGenerator.getMainMessage());
        while (true) {

            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again?  Y/N");
                String againString = scanner.next().trim();
                if (!againString.equalsIgnoreCase("Y")) {
                    System.out.println("Goodbye");
                    break;
                }
                game.reset();
            }

        }
    }

}
