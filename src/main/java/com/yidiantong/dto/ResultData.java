package com.yidiantong.dto;

import org.json.JSONArray;

import java.io.Serializable;

/**
 * Created by wujw on 17/4/24.
 * 返回数据
 */
public class ResultData{
    private String resultMsg;//返回信息
    private int resultCode;//返回状态 0:false,1:true;
    private String resultBody;//返回数据

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultBody() {
        return resultBody;
    }

    public void setResultBody(String resultBody) {
        this.resultBody = resultBody;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "resultMsg='" + resultMsg + '\'' +
                ", resultCode=" + resultCode +
                ", resultBody='" + resultBody + '\'' +
                '}';
    }
}
