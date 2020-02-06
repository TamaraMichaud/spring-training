package com.tamara.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
// ^^
@Configuration
@ComponentScan(basePackages = "com.tamara")
public class WebConfig {
}
