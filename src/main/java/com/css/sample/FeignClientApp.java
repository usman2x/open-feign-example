package com.css.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FeignClientApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientApp.class, args);
    }
}
