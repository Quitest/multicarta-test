package ru.pel.tests.multicartatest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GreetingsController {
    @GetMapping
    public String greetingsPage(){
        return "index";
    }
}
