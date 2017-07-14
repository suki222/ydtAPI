package com.yidiantong.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 处理微信的各种事情
 * Created by wujw on 17/4/27.
 */
@Service
public interface WXService {

    //验证
    boolean checkSignature(HttpServletRequest request);
    //获取access_token
    String getAccessToken(Map map) throws Exception;

    void getInfo(Map map,HttpServletResponse response) throws Exception;
}
