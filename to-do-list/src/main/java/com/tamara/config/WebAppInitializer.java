package com.tamara.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.debug("Starting up WebAppInitializer: onStartup");

        // create web application context (spring container)
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();

        // register the servlet (this servlet talks to the tomcat container)
        springContext.register(WebConfig.class);
            //^^ WebConfig must be annotated with @Configuration for this to work

        // create dispatcher servlet and....
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        // ...register and configure it (purely arbitrary...)
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");


        log.debug("Started up...");
    }
}
