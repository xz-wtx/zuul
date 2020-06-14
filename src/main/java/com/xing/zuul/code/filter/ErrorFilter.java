package com.xing.zuul.code.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xing.zuul.constant.ZuulConst;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulConst.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return ZuulConst.FILTER_ORDER_3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.info("进入异常过滤器");
       // ctx.setResponseBody("出现异常");
        ctx.set(ZuulConst.IS_SUCCESS,false);
        return null;
    }
}
