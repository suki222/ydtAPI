package com.yidiantong.controller;

import com.yidiantong.base.BaseUrls;
import com.yidiantong.base.WXConfig;
import com.yidiantong.bean.WXbean;
import com.yidiantong.bean.WXeventbean;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.BindService;
import com.yidiantong.service.WXService;
import com.yidiantong.utils.DateUtils;
import com.yidiantong.utils.HttpUtils;
import org.dom4j.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信控制类
 * Created by wujw on 17/4/26.
 */
@RestController
@RequestMapping(value = "/WX")
public class WXController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public WXService mServer;
    @Autowired
    private BindService mBindService;

    @RequestMapping
    public String index() {
        return "微信接口";
    }

    @RequestMapping(value = "valid")
    public boolean valid(HttpServletRequest request, HttpServletResponse response) throws DocumentException {
        String echostr = request.getParameter("echostr");
        if (mServer.checkSignature(request)) {
            logger.info("==========echostr==========" + echostr);
//            response.getWriter().print(echostr);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "event", method = RequestMethod.POST)
    public void getEvent(@RequestBody WXeventbean bean, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("==========bean==========" + bean.toString());
        String access_token = mServer.getAccessToken(bean);
        if (bean.getMsgtype().equals(WXConfig.WX_MSGTYPE_EVENT)) {
            switch (bean.getEvent()) {
                case WXConfig.WX_EVENT_SUBSCRIBE://关注
                    logger.info("==========subscribe==========" + bean.toString());
                    mServer.sendMsg(bean, access_token, WXConfig.WX_SEND_TIME, null);
                    break;
                case WXConfig.WX_EVENT_UNSUBSCRIBE://取消关注
                    logger.info("===========unsubscribe=========" + bean.toString());
                    break;
                case WXConfig.WX_EVENT_CLICK://按钮点击
                    logger.info("===========click=========" + bean.toString());
                    //判断是否绑定(通过openid查userid)
                    ResultData data = mBindService.getBindInfo(bean.getFromusername());
                    logger.info("===========statue=========" + data.toString());
                    if (data.getStatue() == 0) {
                        // 否:发送消息,进行绑定
                        mServer.sendMsg(bean, access_token, WXConfig.WX_SEND_BIND, null);
                    } else {
                        // 是:发送到期时间
                        Map map = new HashMap<>();
                        JSONObject obj = new JSONObject(data.getData());
                        map.put("id", obj.opt("userid"));
                        String data_ = HttpUtils.sendGet(BaseUrls.URL_USER00, map, false);//获取用户信息
                        if (data_.equals("404")) {
                            mServer.sendMsg(bean, access_token, WXConfig.WX_SEND_TIME, "没有您的到期日期信息");
                        }else{
                            obj = new JSONObject(data_);
                            System.out.println("======data_======" + obj.opt("akb020"));
                            mServer.sendMsg(bean, access_token, WXConfig.WX_SEND_TIME, "到期日期:\n" + DateUtils.format(obj.optString("akb020")));
                        }
                    }
                    break;
            }
        }
    }

}
