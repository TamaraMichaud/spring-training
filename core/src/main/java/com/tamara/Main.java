package com.tamara;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        LOGGER.warn("BE CAREFUL!!");

        // -- Create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // -- Get "numberGenerator" bean from context (container)
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);
            /* ^^ although you can't see it here; in the beans.xml file we have set "numberGenerator" bean equal to
            numberGeneratorIMPL -> the implementation.*/

        // -- Call a method from the object retreived from container
        int number = numberGenerator.next();
            LOGGER.info("got generated number of: {}", number);
            // ^^ this curly-brace variable transposition is a feature of LOGBACK logger... noice!

        // -- Get "Game" bean from context (containter)
        Game game = context.getBean(Game.class);
            /* ^^ this time we call getBean() with only the .class value compared to at :21, same-same*/

        // -- Call a method from Game (start the game...)
//        game.reset();
        // ^^ now we want to use the Spring container's bean lifecycle callbacks to do all "init()"-type method calls...
        // ^^ and any "close" calls...   see "BeanLifecycleCallbacks.txt" & @PostConstruct / @PreDestroy tags in game class.




        // CLOSE CONTAINER
        context.close();

    }

}
