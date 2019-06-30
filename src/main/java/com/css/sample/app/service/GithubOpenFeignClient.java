package com.css.sample.app.service;

import feign.RequestLine;
import org.springframework.http.ResponseEntity;

public interface GithubOpenFeignClient {

    @RequestLine("GET /user")
    ResponseEntity<?> getUser();
}