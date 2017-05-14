package com.yidiantong.service;

import com.yidiantong.bean.WXeventbean;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理微信的各种事情
 * Created by wujw on 17/4/27.
 */
@Service
public interface WXService {

    //验证
    boolean checkSignature(HttpServletRequest request);

    //获取微信发来的各种信息
    void getWXinfo(HttpServletRequest request);
    //获取access_token
    String getAccessToken(WXeventbean bean) throws Exception;

    /**
     * 发送消息
     * @param bean 微信返回的数据
     * @param access_token
     * @param type 发送类型
     * @param data_ 发送内容
     * @throws JSONException
     */
    void sendMsg(WXeventbean bean,String access_token,int type,String data_) throws JSONException;
}
