package com.yidiantong.base;

import com.yidiantong.dto.ResultDto;
import com.yidiantong.enums.BaseCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务逻辑层基类
 * Created by wujw on 17/4/24.
 */
public class BaseService {
    public ResultDto dto=new ResultDto();//数据返回工具类

    //状态码返回
    public BaseCode getStatus(String data){
        BaseCode code;
        switch (data){
            case "406":
                code= BaseCode.ERROR;
            break;
            case "404":
                code= BaseCode.ERROR;
                break;
            case "409":
                code= BaseCode.ERROR_EXIST;
            break;
            case "201":
                code= BaseCode.SUCCESS;
                break;
            default:
                code= BaseCode.SUCCESS;
            break;
        }
        return code;
//        if (data.isEmpty()){
//            return BaseCode.ERROR;
//        }else{
//            return BaseCode.SUCCESS;
//        }
    }

}
