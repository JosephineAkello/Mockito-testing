package com.example.Mockitotesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hellWorld(){
        return "Hello World...yeeey I made it";
    }
}
