package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "Hello, Spring!";
    }
    //lives in/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    //lives /hello/hello
    //create a handler that creates requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello" + name +"!";
    }

    //handler that handles requests of the form/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello" + name + "!";
    }

    //lives in /hello/form
    @GetMapping("form")
    public String helloForm() {

        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to/hello
                "<input type='text' name='name'> " +
                "<input type='submit' value='Greet me'>" +
                "<form>" +
                "<body>" +
                "<html>";
    }
}
