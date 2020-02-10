package com.tamara.controller;

import com.tamara.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
// ^^ specialisation of the @Component tag for servlet-related functionality
public class DemoController {

    // prior to creation of this class, we were unable to visit our site because we told the dispatcher
    // that the startup servlet will be "/" -> but we need a controller in order to actually handle the
    // requests to and from this servlet.
    // (nb /index.html was also rejected...)


//    @Autowired
    private final DemoServiceImpl demoService;

    @Autowired
    // ^^ this can be here or above; only because we have a single object... if there were more:  here is best
    public DemoController(DemoServiceImpl demoService) {
        this.demoService = demoService;
    }

    @GetMapping("demo-service")
    public String heyService(@RequestParam String user, @RequestParam int age, Model model){
        // ^^ now we must do:  xx/demo-service?user=yy

        model.addAttribute("user", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        model.addAttribute("message", demoService.getWelcomeMessage());
        return "usingDemoService";
    }
    // ^^ these methods/fields all relating to "demoService" are the better version of the below




    @ResponseBody
    // ^^ indicates that the results of the method will be the response body, which allows our "return" value to be printed
    // to the browser as expected
    @GetMapping("/hello")
    public String hello(){
//        return "hello"; // << by setting this to the same as the url in GetMapping - we end up with a circular reference.
//        return "Hey there..."; // << without having any ViewResolver set up this will also return an error...
        return "'Ello 'Ello!"; // << with the @ResponseBody tags we can make this work without any ViewResolver...
    }

    @GetMapping("welcome")
    // ^^ no leading '/'... not required in fact
    // ^^ not using ResponseBody but View instead
    public String ciao(){

        return "firstView";
        // ^^ this is the filename of the view we want to display
        // (minus prefix and suffix specified in the DemoController viewResolver)
    }



    // using a model
    @GetMapping("aloha")
    public String bonjour(Model model){

        log.debug("MODEL TIME!!");
        model.addAttribute("user", "mich");


        return "viewWithModel";
        // ^^ this is the filename of the view we want to display
        // (minus prefix and suffix specified in the DemoController viewResolver)
    }


    // can simply "model.addAttribute", or as below
    @ModelAttribute("message")
    // ^^ if no name specified, Spring will lower-case the first word of your return value...
    public String welcomeMessage(){
        log.debug("welcomeMessage() called");
        return "Welcome to my demo application!";
    }

}
