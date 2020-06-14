package com.xing.zuul;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    OAuth2ProtectedResourceDetails oAuth2RestTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(){
        return new OAuth2RestTemplate(oAuth2RestTemplate);
    }




}
