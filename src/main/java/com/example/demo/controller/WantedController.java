package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wanted")
public class WantedController {

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
