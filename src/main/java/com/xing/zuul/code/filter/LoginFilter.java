package com.xing.zuul.code.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xing.zuul.constant.ZuulConst;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulConst.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return ZuulConst.FILTER_ORDER_0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        /**
         * 初始化
         */
        ctx.set(ZuulConst.IS_CGI_BIN,false);
        ctx.set(ZuulConst.IS_OPEN_API,false);
        //验证token
        ctx.set(ZuulConst.IS_SUCCESS,true);
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("LoginFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURI();

        //提供外部接口必须包含（cgi-bin）
        if((url.contains("/cgi-bin/")||url.contains("/oauth/"))&&!url.contains("/authorize")){
        ctx.set(ZuulConst.IS_CGI_BIN,true);
        ctx.set(ZuulConst.IS_OPEN_API,true);
        }
        //前后的分离，可加可不加(只是把数据进步封装)
        if(url.contains("/api/")){
            ctx.set(ZuulConst.IS_OPEN_API,true);
        }
        //不走路由
        if(url.contains("/open/")){
            ctx.set(ZuulConst.IS_SUCCESS,false);
        }
        return null;
    }
}
