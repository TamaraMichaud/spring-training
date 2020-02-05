package com.tamara.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    private int maxNumber = 100;
    private int guessCount = 4;

    @Bean
    public int maxNumber(){
        return this.maxNumber;
    }
    // ^^ this is not a getter.  the name must match the field in order for @Autowired to work in NumberGeneratorImpl class where
    // we want to use this value...

    @Bean
    public int guessCount(){
        return this.guessCount;
    }

}
