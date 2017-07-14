package com.yidiantong.controller;

import com.yidiantong.dto.ResultData;
import com.yidiantong.service.WXService;
import com.yidiantong.utils.HttpUtils;
import com.yidiantong.utils.XmlUtils;
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
import java.io.Writer;
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

    @RequestMapping
    public String index() {
        return "微信接口";
    }

    @RequestMapping(value = "ydtValid")
    public void valid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();
        if (method.equals("GET")) {//微信验证
            String echostr = request.getParameter("echostr");
            if (mServer.checkSignature(request)) {
                logger.info("==========echostr==========" + echostr);
                Writer writer = response.getWriter();
                writer.write(echostr);
            }
        } else {//接收微信消息
            Map map = XmlUtils.xml2map(request.getInputStream());
            logger.info("==========wxMsg==========" + map.toString());
            logger.info("==========msgtype==========" + map.get("MsgType"));
            mServer.getInfo(map,response);
        }
    }

    @RequestMapping(value = "getOpenId", method = RequestMethod.POST)
    public ResultData get(@RequestBody Map params) throws Exception {
        // 解释以下,先拿openid,判断是否绑定,否:绑定;是:返回true
       return new ResultData();
    }

}
