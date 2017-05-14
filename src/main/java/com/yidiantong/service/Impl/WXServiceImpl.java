package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseUrls;
import com.yidiantong.base.WXConfig;
import com.yidiantong.bean.WXeventbean;
import com.yidiantong.service.WXService;
import com.yidiantong.utils.HttpUtils;
import com.yidiantong.utils.ShaUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wujw on 17/4/27.
 */
@Service
public class WXServiceImpl implements WXService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String TOKEN="ylzinfo";

    @Override
    public boolean checkSignature(HttpServletRequest request) {
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        logger.info("==========timestamp=========="+timestamp);
        logger.info("==========nonce=========="+nonce);
        logger.info("==========signature=========="+signature);

        ArrayList<String> list=new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(TOKEN);
        //字典序排序
        Collections.sort(list);
        String tmpStr="";
        for(int i=0;i<list.size();i++){
            tmpStr+=list.get(i);
        }
        //sha1加密
        tmpStr= ShaUtil.getSha1(tmpStr);
        logger.info("==========tmpStr=========="+tmpStr);
        if( tmpStr.equals(signature)){
//            response.getWriter().print(echostr);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void getWXinfo(HttpServletRequest request) {

    }

    @Override
    public String getAccessToken(WXeventbean bean) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", WXConfig.WX_APPID);
        params.put("secret", WXConfig.WX_SECRET);
        String jstoken= HttpUtils.sendGet(WXConfig.URL_WX_TOKEN,params,true);
        JSONObject json=new JSONObject(jstoken);
        logger.info("==========access==========" +json.get("access_token").toString());
        return json.get("access_token").toString();
    }

    @Override
    public void sendMsg(WXeventbean bean,String access_token,int type,String data_) throws JSONException {
        String url=WXConfig.URL_WX_SENDMSG+access_token;//请求路径
        JSONObject json=new JSONObject();
        JSONObject newJson=new JSONObject();
        json.put("touser",bean.getFromusername());//用户openid
        json.put("msgtype","text");//消息类型

        switch (type){
            case WXConfig.WX_SEND_WELCOME:
                newJson.put("content",WXConfig.WX_WELCOME);//消息内容
                break;
            case WXConfig.WX_SEND_BIND:
                String content="您还未绑定,请点击[<a href=\"http://wjw.idocore.com/yidiantong/index.html?openid="+bean.getFromusername()+"#/Bind?\">绑定</a>]";
                newJson.put("content",content);//消息内容
                break;
            case WXConfig.WX_SEND_TIME:
                newJson.put("content",data_);//消息内容
                break;
        }
        json.put("text",newJson);
        System.out.println("==========params==========" + json);
        String data=HttpUtils.sendJsonPost(url,json);//发送消息
        System.out.println("==========data==========" + data);
    }
}
