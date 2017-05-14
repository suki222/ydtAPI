package com.yidiantong.dto;

import com.yidiantong.enums.BaseCode;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 数据返回统一处理方法
 * Created by wujw on 17/4/24.
 */
public class ResultDto {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回数据防范
     * @param baseCode 状态名
     * @param obj  返回数据
     * @return
     */
    public ResultData _data(BaseCode baseCode, String obj){
        ResultData data=new ResultData();
        data.setCode(baseCode.getCode());
        data.setMessage(baseCode.getMessage());
        data.setMethod("POST");
        data.setStatue(baseCode.getCode()=="000000"?1:0);

        data.setTime(LocalDate.now()+" "+ LocalTime.now().withNano(0));
        data.setData(obj);
        System.out.println("-----接口返回信息-----"+data.toString());
        return data;
    }
}
