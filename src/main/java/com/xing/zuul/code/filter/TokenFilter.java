package com.xing.zuul.code.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xing.zuul.constant.ZuulConst;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulConst.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return ZuulConst.FILTER_ORDER_1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        return (boolean) context.get(ZuulConst.IS_SUCCESS);
    }

    @Override
    public Object run() throws ZuulException {

        return null;
    }
}
