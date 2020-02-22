package me.kay.controller;

import me.kay.KayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarterTestController {

    @Autowired
    KayService kayService;

    @GetMapping("/starter/hello")
    public String sayHello(){
        return kayService.sayKay("kay");
    }
}
