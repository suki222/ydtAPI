package com.yidiantong.base;

/**
 * Created by wujw on 17/4/28.
 */
public class WXConfig {

    public static final String URL_WX_TOKEN="https://api.weixin.qq.com/cgi-bin/token";//getaccesstoken
    public static final String URL_WX_SENDMSG="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";//发送消息

    public static final String WX_APPID="wx3aa32ed41865ff44";//appid
    public static final String WX_SECRET="1ee9300b52a2b39efd94677e0e571f67";//secret

    public static final String WX_MSGTYPE_EVENT="event";//事件
    public static final String WX_EVENT_SUBSCRIBE="subscribe";//订阅
    public static final String WX_EVENT_UNSUBSCRIBE="unsubscribe";//取消订阅
    public static final String WX_EVENT_CLICK="CLICK";//取消订阅

    public static final int WX_SEND_WELCOME=100;//欢迎
    public static final int WX_SEND_BIND=101;//绑定
    public static final int WX_SEND_TIME=102;//时间


    //欢迎语
    public static final String WX_WELCOME="欢迎关注E点通，E点通是最方便快捷的网上医保申报平台。目前服务已覆盖福建各县区超过100,000家单位。\n" +
            "->[<a href=\"http://wjw.idocore.com/yidiantong/index.html#/BuyServer\">立即购买</a>]老用户点击这里缴费续费\n" +
            "->[<a href=\"http://wjw.idocore.com/yidiantong/index.html#/OpenGuide\">开通指南</a>]新用户要先点击这里开通哦~\n" +
            "->[<a href=\"http://wjw.idocore.com/yidiantong/index.html#/ReMine\">优惠活动</a>]查看最新优惠\n" +
            "->[<a href=\"http://wjw.idocore.com/yidiantong/index.html#/ReMine\">常见问题</a>]查看常见问题解答\n" +
            "->[<a href=\"http://wjw.idocore.com/yidiantong/index.html#/FeedBack\">在线留言</a>]提出您宝贵的意见";

    public static final String WX_BIND="您还未登录,请点击[<a href=\"http://wjw.idocore.com/yidiantong/index.html?openid='test'#/ReMine?\">登录</a>]";
}
