package com.john.sc.consumer.controller;

import com.john.sc.consumer.client.MyFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class consumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private MyFeginClient feginClient;
    @RequestMapping(value = "/ribbon")
    public String index() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider1");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        System.out.println(url);
        //restTemplate.getForObject("http://provider1/hello", String.class);
        return restTemplate.getForObject(url, String.class);
    }
    @RequestMapping(value = "/ribbon2")
    public String index2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider1");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        System.out.println(url);
        return restTemplate.getForObject("http://provider1/hello", String.class);
        //TODO  bug?
    }
    @RequestMapping(value = "/ribbon3")
    public String index3() {
        return feginClient.consumer();
    }
}
