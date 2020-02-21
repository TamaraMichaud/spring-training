package com.tamara.springboottraining1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootTraining1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTraining1Application.class, args);
	}

}


// ^^ we have put this class in the root package so that it will scan all classes in this and sub-packages
// ^^ if we moved it elsewhere we might have issues