package com.tamara.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
// ^^
@Configuration
@ComponentScan(basePackages = "com.tamara")
public class WebConfig {

    // constants
    public static final String RESOLVER_PREFIX = "/webapp/WEB-INF/view/";
//    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";  //TODO: this one for cargo / real deploy. the above for tomcat dev plugin
    public static final String RESOLVER_SUFFIX = ".jsp";


    @Bean
    public ViewResolver viewResolver(){
        // create an internal resource view resolver
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        // ^^ latter == subclass of former. automatically handles JSTL (jsp tags)
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);

        return viewResolver;
    }


}
