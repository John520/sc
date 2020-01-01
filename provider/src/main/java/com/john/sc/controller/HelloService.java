package com.john.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;


@RestController
public class HelloService {
//    private final Logger logger=Logger.getLogger(this.getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/hello")
    public String index(){
        List<String> services = client.getServices();
        services.forEach(it-> System.out.println("service:"+it+"\n"));
        return "hello world"+ LocalTime.now();
    }
}
