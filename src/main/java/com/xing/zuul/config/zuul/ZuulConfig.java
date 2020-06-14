package com.xing.zuul.config.zuul;

import com.xing.zuul.code.filter.ErrorFilter;
import com.xing.zuul.code.filter.LoginFilter;
import com.xing.zuul.code.filter.ResultFilter;
import com.xing.zuul.code.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public LoginFilter loginFilter(){
        return new LoginFilter();
    }
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){ return new ErrorFilter(); }
    @Bean
    public ResultFilter resultFilter(){
        return new ResultFilter();
    }
}
