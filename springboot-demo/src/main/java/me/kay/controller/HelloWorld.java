package me.kay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloWorld {

    @Value("person.last-name")
    private String name;

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello, " + name;
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
