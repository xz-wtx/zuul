package com.xing.zuul.controller.base;

import com.alibaba.fastjson.JSON;
import com.xing.zuul.pojo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
public class BaseErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;
    @Autowired
    public BaseErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes=errorAttributes;
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, WebRequest req){
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(req, false);
        ResultVO result = new ResultVO((Integer) attr.get("status"), attr.get("message"), request.getRequestURL().toString());
        return JSON.toJSONString(result);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
