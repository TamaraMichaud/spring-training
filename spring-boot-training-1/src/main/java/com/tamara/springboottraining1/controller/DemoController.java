package com.tamara.springboottraining1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo(){
        log.debug("demo method call");
        return "Hello Spring Boot!";
    }

    // a basic View
//    @ResponseBody << without this we get a circular reference warning... unless we add things into application.properties file...
    @GetMapping("welcome")
    public String welcome(Model model){
        log.debug("welcome method called");
        model.addAttribute("message", "welcome to my spring boot sample app");
        return "welcome"; // <<  the view name, remember
    }

}
