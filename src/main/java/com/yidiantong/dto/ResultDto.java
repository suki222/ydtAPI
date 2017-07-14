package com.yidiantong.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

/**
 * 数据返回统一处理方法
 * Created by wujw on 17/4/24.
 */
public class ResultDto {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回数据防范
     * @return
     */
    public ResultData _data(int code, String body,String msg) throws ParseException {
        ResultData data=new ResultData();
        data.setResultMsg(msg);
        data.setResultCode(code);
        data.setResultBody(body);
        System.out.println("-----接口返回信息-----"+data.toString());
        return data;
    }
}
