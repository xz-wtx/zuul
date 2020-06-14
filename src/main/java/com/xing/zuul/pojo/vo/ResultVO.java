package com.xing.zuul.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVO {

    private Integer status;

    private Object data;

    private String url;

    public ResultVO(Integer status,Object obj){
        this.status=status;
        this.data=obj;
    }
}
