package com.john.sc.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider1")
public interface MyFeginClient {
    @GetMapping("/hello")
    String consumer();
}
