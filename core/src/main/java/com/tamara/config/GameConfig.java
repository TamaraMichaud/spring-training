package com.tamara.config;

import com.tamara.GuessCount;
import com.tamara.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    private int baked_potato = 100;
    private int guessCount = 4;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return this.baked_potato;
    }
    // ^^ this is not a getter.  the name must match the field in order for
    // @Autowired to work in NumberGeneratorImpl class where we want to use this value...

    // ^^ this is obviously not ideal, which is where Qualifiers come into play

    @Bean
    @GuessCount
    public int NAMESDONTMATTERguessCount(){
        return this.guessCount;
    }

}
