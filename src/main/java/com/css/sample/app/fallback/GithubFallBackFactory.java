package com.css.sample.app.fallback;

import com.css.sample.app.service.GithubSpringOpenFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GithubFallBackFactory implements FallbackFactory<GithubSpringOpenFeignClient> {

    @Override
    public GithubSpringOpenFeignClient create(Throwable cause) {
        return new GithubFallBack(cause);
    }
}