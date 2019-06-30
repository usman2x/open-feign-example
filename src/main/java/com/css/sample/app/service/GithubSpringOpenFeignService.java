package com.css.sample.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GithubSpringOpenFeignService {
    private final GithubSpringOpenFeignClient githubClient;

    @Autowired
    public GithubSpringOpenFeignService(GithubSpringOpenFeignClient githubClient) {
        this.githubClient = githubClient;
    }

    public ResponseEntity<?> getUser() {
        return githubClient.getUser();
    }
}
