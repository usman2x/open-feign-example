package com.css.sample.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GithubOpenFeignService {
    private GithubOpenFeignClient githubOpenFeignClient;
    private final BasicAuthRequestInterceptor basicAuthRequestInterceptor;

    @Autowired
    public GithubOpenFeignService(BasicAuthRequestInterceptor basicAuthRequestInterceptor) {
        this.basicAuthRequestInterceptor = basicAuthRequestInterceptor;
    }

    @PostConstruct
    public void initOpenFeignClient() {
        this.githubOpenFeignClient = Feign.builder()
                .requestInterceptor(basicAuthRequestInterceptor)
                .encoder(new JacksonEncoder())
                .decoder(customDecoder())
                .target(GithubOpenFeignClient.class, "https://api.github.com");
    }

    @Bean
    public Decoder customDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () ->
                new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    private ObjectMapper customObjectMapper() {
        return new ObjectMapper();
    }

    public ResponseEntity<?> getUser() {
        return githubOpenFeignClient.getUser();
    }
}
