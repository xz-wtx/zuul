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
    public boolean shouldFilter() { return true; }

    @Override
    public Object run() throws ZuulException {
        log.info("LoginFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.set(ZuulConst.IS_SUCCESS,true);
        ctx.set(ZuulConst.IS_OPEN_API,true);
        return null;
    }
}
