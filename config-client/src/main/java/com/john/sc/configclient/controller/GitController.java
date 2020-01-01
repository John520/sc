package com.john.sc.configclient.controller;

import com.john.sc.configclient.domain.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitController {

    @Autowired
    private GitConfig gitConfig;



    @GetMapping(value = "show")
    public Object show(){
        return gitConfig.toString();
    }

}