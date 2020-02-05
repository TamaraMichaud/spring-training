package com.tamara.config;

import com.tamara.GuessCount;
import com.tamara.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
// ^^ classpath or file: ... but really should be classpath. =resources folder
public class GameConfig {

    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    // ^^ variable as labelled in file, :x == default value if not found
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return this.maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return this.guessCount;
    }

// all of the below was prior to "@PropertySource" line (reading from properties file now)

//    private int baked_potato = 100;
//    private int guessCount = 4;
//
//    @Bean
//    @MaxNumber
//    public int maxNumber(){
//        return this.baked_potato;
//    }
//    // ^^ this is not a getter.  the name must match the field in order for
//    // @Autowired to work in NumberGeneratorImpl class where we want to use this value...
//
//    // ^^ this is obviously not ideal, which is where Qualifiers come into play
//
//    @Bean
//    @GuessCount
//    public int NAMESDONTMATTERguessCount(){
//        return this.guessCount;
//    }

}
