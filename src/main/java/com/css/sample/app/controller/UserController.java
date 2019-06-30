package com.css.sample.app.controller;
import com.css.sample.app.service.GithubOpenFeignService;
import com.css.sample.app.service.GithubSpringOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private final GithubOpenFeignService githubOpenFeignService;
    private final GithubSpringOpenFeignService githubSpringOpenFeignService;


    @Autowired
    public UserController(GithubOpenFeignService githubOpenFeignService, GithubSpringOpenFeignService githubSpringOpenFeignService) {
        this.githubOpenFeignService = githubOpenFeignService;
        this.githubSpringOpenFeignService = githubSpringOpenFeignService;
    }

    @GetMapping(path = "/github/feign/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> githubOpenFeign() {
        return new ResponseEntity<>(githubOpenFeignService.getUser(), HttpStatus.OK);
    }

    @GetMapping(path = "/github/spring/feign/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> githubSpringFeign() {
        return new ResponseEntity<>(githubSpringOpenFeignService.getUser(), HttpStatus.OK);
    }
}
