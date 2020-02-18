package com.tamara.springboottraining1.controller;

import com.tamara.springboottraining1.model.RawFile;
import com.tamara.springboottraining1.service.FileTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Slf4j
@Controller
public class DemoController {

    @Autowired
    RawFile fileToTreat;
    @Autowired
    FileTransformer fileTransformer;

    @ResponseBody
    @GetMapping("demo")
    public String demo() {
        log.debug("demo method call");
        return "Hello Spring Boot!";
    }

    // a basic View
//    @ResponseBody << without this we get a circular reference warning... unless we add things into application.properties file...
    @GetMapping("welcome")
    public String welcome(Model model) {
        log.debug("welcome method called");
        model.addAttribute("message", "welcome to my spring boot sample app");
        return "welcome"; // <<  the view name, remember
    }


    @GetMapping("test-file-read")
//    @QuartzDataSource()
    public String cronJobNotReally() {
        log.info("let's try and read a file...");

        try {
            System.out.println("Here is the info about our file:");
            fileTransformer.scanFile(fileToTreat);

        } catch (IOException e) {
            log.error("Failed to find file.");
            e.printStackTrace();
        }

        return "welcome";
    }

}
