package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseData;
import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.base.WXConfig;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.WXService;
import com.yidiantong.utils.DateUtils;
import com.yidiantong.utils.HttpUtils;
import com.yidiantong.utils.ShaUtil;
import com.yidiantong.utils.XmlUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wujw on 17/4/27.
 */
@Service
public class WXServiceImpl extends BaseService implements WXService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String TOKEN="ylzinfo";


    @Override
    public boolean checkSignature(HttpServletRequest request) {
        System.out.println("-----微信验证------");
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
    public String getAccessToken(Map map) throws Exception {
        System.out.println("-----获取accesstoken------");
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
    public void getInfo(Map map,HttpServletResponse response) throws Exception {
        //文本消息
        if(map.get("MsgType").toString().equals(WXConfig.WX_MSGTYPE_TEXT)){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(sendMsg(map, doText(map)));
        }
        // 事件消息
        else if (map.get("MsgType").toString().equals(WXConfig.WX_MSGTYPE_EVENT)) {
            response.setCharacterEncoding("UTF-8");
            if(!doEvent(map).equals(""))
            response.getWriter().write(sendMsg(map, doEvent(map)));
        }
    }

    /**
     * 发送消息
     * @param map
     * @param content
     * @return
     */
    public String sendMsg(Map map, String content) {
        Map newMap=new HashMap<>();
        newMap.put("ToUserName",map.get("FromUserName"));
        newMap.put("FromUserName",map.get("ToUserName"));
        newMap.put("CreateTime",map.get("CreateTime"));
        newMap.put("MsgType","text");
        newMap.put("Content",content);
        return XmlUtils.toXml(newMap);
    }

    /**
     * 事件消息处理
     * @return
     */
    private String doEvent(Map map) throws Exception {
        String content="";
        switch (map.get("Event").toString()) {
            case WXConfig.WX_EVENT_SUBSCRIBE://关注
                logger.info("==========subscribe==========" + map.toString());
                content=WXConfig.WX_WELCOME;
                if(map.containsKey("Ticket")){
                    System.out.println("-----统计------");
                    JSONObject obj=new JSONObject();
                    obj.put("sceneId",map.get("EventKey").toString().split("qrscene_")[1]);
                    HttpUtils.sendJsonPost(getURL(BaseUrls.URL_COUNT),obj);
                    logger.info("==========EventKey==========" + map.get("EventKey").toString().split("qrscene_")[1]);
                }
                break;
            case WXConfig.WX_EVENT_UNSUBSCRIBE://取消关注
                logger.info("===========unsubscribe=========" + map.toString());
                break;
//            case WXConfig.WX_EVENT_CLICK://点击事件
                //判断是否绑定(通过openid查userid)
//                ResultData data = mBindService.getBindInfo(map.get("FromUserName").toString());
//                if (data.getStatue() == 0) {
//                    // 否:发送消息,进行绑定
//                    content = "您还未绑定,请点击[<a href=\"http://"+BaseUrls.BASE_WEB+"?openid=" + map.get("FromUserName").toString() + "#/Bind?\">绑定</a>]";
//                } else {
//                    switch (map.get("EventKey").toString()) {
//                        case WXConfig.WX_GET_DATE:// 获取时间事件,返回时间信息
//                            Map newMap = new HashMap<>();
//                            JSONObject obj = new JSONObject(data.getData());
//                            newMap.put("id", obj.opt("userid"));
//                            String data_ = HttpUtils.sendGet(getURL(BaseUrls.URL_USER00), newMap, false);//获取用户信息
//                            if (data_.equals("404")) {
//                                content = "没有您的到期日期信息";
//                            } else {
//                                obj = new JSONObject(data_);
//                                content = "到期日期:\n" + DateUtils.format(obj.optString("akb020"));
//                            }
//                            break;
//                        case WXConfig.WX_KEY_BIND://绑定事件
//                            content = "您正在进行解绑操作,去[<a href=\"http://"+BaseUrls.BASE_WEB+"?openid=" + map.get("FromUserName").toString() + "#/UnBind?\">解绑</a>]";
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                break;
            case WXConfig.WX_EVENT_SCAN://扫码事件
                logger.info("==========Ticket==========" +map.get("Ticket").toString());
                logger.info("==========EventKey==========" +map.get("EventKey").toString());
                System.out.println("-----统计------");
                JSONObject obj=new JSONObject();
                obj.put("sceneId",map.get("EventKey").toString());
                HttpUtils.sendJsonPost(getURL(BaseUrls.URL_COUNT),obj);
                break;
        }
        return content;
    }

    /**
     * 自动回复消息处理
     * @param map
     * @return
     */
    private String doText(Map map){
        /**
         * 逻辑写一下:
         * 1.匹配关键词
         * 匹配:回复消息1,保存openid和匹配状态
         * 不匹配:回复消息2
         * 2.判断openid保存状态
         * 不匹配||不存在:走1->匹配关键词
         * 匹配:判断用户回复的数字,回复消息,清除保存的openid
         * 3.匹配"解决"||"未解决"
         * 匹配:回复消息,清除保存的openid
         */
        String content="";
        if(map.get("Content").toString().equals("解决")){
            content=WXConfig.WX_ANSWER_HAPPY_END;
            if(BaseData.answerMap.containsKey(map.get("FromUserName").toString())){
                BaseData.answerMap.remove(map.get("FromUserName").toString());
            }
        }else if(map.get("Content").toString().equals("未解决")){
            content=WXConfig.WX_ANSWER_BAD_END;
            if(BaseData.answerMap.containsKey(map.get("FromUserName").toString())){
                BaseData.answerMap.remove(map.get("FromUserName").toString());
            }
        }else if(BaseData.answerMap.containsKey(map.get("FromUserName").toString())){
            switch (map.get("Content").toString()){
                case "1":
                    content=WXConfig.WX_ANSWER_LEVEL2_1;
                    break;
                case "2":
                    content=WXConfig.WX_ANSWER_LEVEL2_2;
                    break;
                case "3":
                    content=WXConfig.WX_ANSWER_LEVEL2_3;
                    break;
                case "4":
                    content=WXConfig.WX_ANSWER_LEVEL2_4;
                    break;
                case "5":
                    content=WXConfig.WX_ANSWER_LEVEL2_5;
                    break;
                case "6":
                    content=WXConfig.WX_ANSWER_LEVEL2_6;
                    break;
                case "7":
                    content=WXConfig.WX_ANSWER_LEVEL2_7;
                    break;
                default:
                    content="请输入对应题号查看答案~";
                    break;
            }
            BaseData.answerMap.remove(map.get("FromUserName").toString());
        }else{
            boolean isMatch=checkKeyword(map.get("Content").toString());
            if(isMatch){
                content=WXConfig.WX_ANSWER_LEVEL1_TRUE;
                BaseData.answerMap.put(map.get("FromUserName").toString(),isMatch);
            }else{
                content=WXConfig.WX_ANSWER_LEVEL1_FALSE;
            }
        }
        return content;
    }

    /**
     * 匹配关键词
     * @param keyword 用户回复的消息
     * @return
     */
    private boolean checkKeyword(String keyword){
        boolean isMatch=false;
        for(int i=0;i<WXConfig.WX_KEYWORD.length;i++){
            if(keyword.indexOf(WXConfig.WX_KEYWORD[i])!=-1){
                isMatch=true;
                break;
            }
        }
        return isMatch;
    }
}
