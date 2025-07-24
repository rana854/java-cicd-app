package com.example.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootappApplication.class, args);
    }
     @GetMapping("/")
    public String home() {
        return "Hello";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
