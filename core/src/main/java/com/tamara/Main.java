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

        //CREATE CONTAINER
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);
        /* ^^ although you can't see it here; in the beans.xml file we have set "numberGenerator" bean equal to
        numberGeneratorIMPL -> the implementation.
         */

        // CALL A METHOD FROM THE OBJECT CREATED BY OUR BEAN GENERATOR
        int number = numberGenerator.next();
        LOGGER.info("got generated number of: {}", number);
        // ^^ this curly-brace variable transposition is a feature of LOGBACK logger... noice

        // CLOSE CONTAINER
        context.close();

    }

}
