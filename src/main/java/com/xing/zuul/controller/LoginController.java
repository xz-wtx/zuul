package com.xing.zuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {



    @RequestMapping("/login")
    public void login(HttpServletResponse response){

        //        try {
//            response.sendRedirect("http://localhost:8081/uaa/oauth/authorize?response_type=code&redirect_uri=http://localhost:8080/zuul/code&client_id=app&scop=all");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @RequestMapping("/code")
    @ResponseBody
    public String code(String code){
        System.out.println(code);

        return "112";
    }
}
