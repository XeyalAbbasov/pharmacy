package com.commerce.pharmacy.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping({"/home",""})
    public String openHomePage(){

        return "Welcome to Home Page";
    }
}
