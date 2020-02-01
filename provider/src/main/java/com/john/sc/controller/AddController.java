package com.john.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    @RequestMapping(value = "/add")
    public String add(@RequestParam("a")Integer a, @RequestParam("b")Integer b) {
        int c=a+b;
        return "a+b="+c;
    }
}
