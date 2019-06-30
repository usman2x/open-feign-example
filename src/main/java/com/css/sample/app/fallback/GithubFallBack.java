package com.css.sample.app.fallback;

import com.css.sample.app.service.GithubSpringOpenFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class GithubFallBack implements GithubSpringOpenFeignClient {
    private final Throwable cause;

    public GithubFallBack(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseEntity<?> getUser() {
        log.info("Error occurred due to {} ", cause.getMessage(), cause);
        return new ResponseEntity<>("GIT HUB FALLBACK occurred", HttpStatus.NOT_FOUND);
    }
}
