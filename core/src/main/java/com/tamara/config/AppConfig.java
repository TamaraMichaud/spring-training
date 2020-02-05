package com.tamara.config;


import com.tamara.Game;
import com.tamara.GameImpl;
import com.tamara.NumberGenerator;
import com.tamara.NumberGeneratorImpl;
import com.tamara.messageGeneratorChallenge.MessageGenerator;
import com.tamara.messageGeneratorChallenge.MessageGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
// ^^ AppConfig can control all of the config
@ComponentScan(basePackages = "com.tamara")
public class AppConfig {

    //   -- bean methods --  (by default, beans are named the same as their class... you can override this but not recommended)
//    @Bean
//    public NumberGenerator numberGenerator() {
//        return new NumberGeneratorImpl();
//    }
//
//    @Bean
//    public Game game() {
//        return new GameImpl();
//    }
//
//    @Bean
//    public MessageGenerator messageGenerator() {
//        return new MessageGeneratorImpl();
//    }
}
