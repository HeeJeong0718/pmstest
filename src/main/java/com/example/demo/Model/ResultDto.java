package com.example.demo.Model;

import com.example.demo.config.Common;
import lombok.Builder;
import lombok.Getter;

import javax.xml.transform.Result;

@Getter
public class ResultDto {
    String result = Common.FAIL;

    int resultCode = -1;

    Object data;

    @Builder
    public ResultDto(String result, int resultCode ,Object data){
        this.result = result;
        this.resultCode = resultCode;
        this.data = data;
    }
}
