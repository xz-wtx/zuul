package com.xing.zuul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping("/login")
    public void login(HttpServletResponse response){
        oAuth2RestTemplate.getAccessToken();
        //        try {
//            response.sendRedirect("http://localhost:8081/uaa/oauth/authorize?response_type=code&redirect_uri=http://localhost:8080/zuul/code&client_id=app&scop=all");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @RequestMapping("/code")
    public String code(String code){
        System.out.println(code);

        return "112";
    }
}
