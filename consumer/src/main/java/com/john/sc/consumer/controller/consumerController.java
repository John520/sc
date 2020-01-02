package com.john.sc.consumer.controller;

import com.john.sc.consumer.client.ComputeClient;
import com.john.sc.consumer.client.MyFeginClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class consumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private MyFeginClient feginClient;
    @Autowired
    private ComputeClient computeClient;

    @RequestMapping(value = "/ribbon")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String index() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider1");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        System.out.println(url);
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
    @RequestMapping(value = "/compute")
    public String index3(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return computeClient.add(a,b);
    }
    public String fallbackMethod(){
        return "ribbon fallbackMethod";
    }

}
