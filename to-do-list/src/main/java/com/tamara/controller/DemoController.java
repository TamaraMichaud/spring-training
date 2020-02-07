package com.tamara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// ^^ specialisation of the @Component tag for servlet-related functionality
public class DemoController {

    // prior to creation of this class, we were unable to visit our site because we told the dispatcher
    // that the startup servlet will be "/" -> but we need a controller in order to actually handle the
    // requests to and from this servlet.
    // (nb /index.html was also rejected...)

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

}
