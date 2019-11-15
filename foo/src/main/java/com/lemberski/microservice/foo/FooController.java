package com.lemberski.microservice.foo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FooController {

    @Value("${path.bar:https://dummy}")
    private String barPath;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String index() {
        return "Hello from Foo";
    }

    @GetMapping("/foobar")
    @HystrixCommand(fallbackMethod = "defaultFoobar")
    public String foobar() {
        return restTemplate.getForObject(barPath, String.class);
    }

    public String defaultFoobar() {
        return "Hello from Bar (Circuit Breaker default)";
    }

}