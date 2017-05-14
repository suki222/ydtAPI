package com.yidiantong.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wujw on 17/4/27.
 */
public class WXbean {
    String echostr;
    String signature;
    String timestamp;
    String nonce;
    WXeventbean data;

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public WXeventbean getBean() {
        return data;
    }

    public void setBean(WXeventbean data) {
        this.data = data;
    }

    public WXeventbean getData() {
        return data;
    }

    @JsonProperty(value="data")
    public void setData(WXeventbean data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "WXbean{" +
                "echostr='" + echostr + '\'' +
                ", signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", data=" + data +
                '}';
    }
}
