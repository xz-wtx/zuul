package com.xing.zuul.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class demo {
    @Autowired
    RestTemplate restTemplate;

    @Scheduled(cron = "0/5 * * * * *")
    public void  get(){
//        System.out.println("定时器开。。。。");
//        JSONObject result = restTemplate.getForObject("http://localhost:8080/zuul/uaa/oauth/token?username=web&password=1111&grant_type=sms&client_id=appo&client_secret=12345", JSONObject.class);
//        System.out.println(result);
        
    }
}
