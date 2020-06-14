package com.xing.zuul.code.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xing.zuul.constant.ZuulConst;
import com.xing.zuul.pojo.vo.ResultVO;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;

@Log4j2
public class ResultFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulConst.POST_TYPE;
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
        log.info("postFilter");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        int status = response.getStatus();
        InputStream in = context.getResponseDataStream();
        String body = IOUtils.toString(in);

        //针对第三方始终返回200调用成功，封装请求结果
        if((Boolean) context.get(ZuulConst.IS_OPEN_API)){
            response.setStatus(HttpStatus.OK.value());
            if(!isXmlDocument(in)){
               context.setResponseBody(JSON.toJSONString(new ResultVO(status,body)));

            }else{
                context.setResponseBody(JSON.toJSONString(new ResultVO(status,body)));
            }
            return null;
        }
        //内部系统不受管制，返回状态码根据子系统返回确定
        context.setResponseBody(JSON.toJSONString(new ResultVO(status,body,request.getRequestURL().toString())));
        return null;
    }
    private static boolean isXmlDocument(InputStream in){
        boolean flag = true;
        try {
            DocumentBuilderFactory foctory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = foctory.newDocumentBuilder();
            builder.parse(in);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


}
