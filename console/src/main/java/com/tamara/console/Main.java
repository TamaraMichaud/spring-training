package com.tamara.console;

//import com.tamara.config.DELETE_AppConfig;
import com.tamara.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";
// ^^ no longer used.  see AppConfig instead

    public static void main(String[] args) {
//        LOGGER.warn("BE CAREFUL!!");

        // -- Create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // -- Get "numberGenerator" bean from context (container)
//        NumberGenerator numberGenerator = context.getBean("nameOfMyBean", NumberGenerator.class);
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class); // << trashed the name part since it's a bit shit
        // ^^ we can have this aimed at the interface because there is only one implementation of this class... however if there were
        // multiple we'd need to use qualifiers... (later in course)

            /* ^^ although you can't see it here; in the beans.xml file we have set "numberGenerator" bean equal to
            numberGeneratorIMPL -> the implementation.*/

        // -- Call a method from the object retreived from container
//        int number = numberGenerator.next();
//            LOGGER.debug("got generated number of: {}", number);
            // ^^ this curly-brace variable transposition is a feature of LOGBACK logger... noice!

        // -- Get "Game" bean from context (containter)
//        Game game = context.getBean(Game.class);
            /* ^^ this time we call getBean() with only the .class value compared to at :21, same-same*/

        // -- Call a method from Game (start the game...)
//        game.reset();
        // ^^ now we want to use the Spring container's bean lifecycle callbacks to do all "init()"-type method calls...
        // ^^ and any "close" calls...   see "BeanLifecycleCallbacks.txt" & @PostConstruct / @PreDestroy tags in game class.


//        MessageGenerator yoMama = context.getBean(MessageGenerator.class);
//        LOGGER.debug(yoMama.getResultMessage());



        // CLOSE CONTAINER
        context.close();

    }

}
