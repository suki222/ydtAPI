package com.yidiantong.dto;

import org.json.JSONArray;

import java.io.Serializable;

/**
 * Created by wujw on 17/4/24.
 * 返回数据
 */
public class ResultData{
    private String code;//返回码
    private String message;//返回信息
    private int statue;//返回状态 0:false,1:true;
    private String method;//返回方法
    private String time;//返回时间
    private String data;//返回数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", statue=" + statue +
                ", method='" + method + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
