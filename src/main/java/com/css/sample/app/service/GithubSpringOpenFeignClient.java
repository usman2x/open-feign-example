package com.css.sample.app.service;

import com.css.sample.app.config.GitHubClientConfig;
import com.css.sample.app.fallback.GithubFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url = "https://api.github.com", name = "GITHUB-SPRING-FEIGN-CLIENT",
        configuration = GitHubClientConfig.class, fallbackFactory = GithubFallBackFactory.class)
public interface GithubSpringOpenFeignClient {

    @GetMapping(value = "/user")
    ResponseEntity<?> getUser();
}
