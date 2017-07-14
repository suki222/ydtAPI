package com.yidiantong.base;

/**
 * Created by wujw on 17/4/28.
 */
public class WXConfig {

    public static final String URL_WX_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";//getaccesstoken

    public static final String WX_APPID = "wx3aa32ed41865ff44";//appid
    public static final String WX_SECRET = "1ee9300b52a2b39efd94677e0e571f67";//secret

    public static final String WX_MSGTYPE_EVENT = "event";//事件
    public static final String WX_MSGTYPE_TEXT = "text";//消息文本
    public static final String WX_EVENT_SUBSCRIBE = "subscribe";//订阅
    public static final String WX_EVENT_UNSUBSCRIBE = "unsubscribe";//取消订阅
    public static final String WX_EVENT_CLICK = "CLICK";//点击事件
    public static final String WX_EVENT_SCAN = "SCAN";//扫描二维码事件

    //----------------------微信按钮事件----------------------
    public static final String WX_KEY_BIND = "KEY_BIND";//绑定事件
    public static final String WX_GET_DATE = "GET_DATE";//获取到期时间

    //----------------------自动回复文案-------------------------
    public static final String[] WX_KEYWORD = {"注册", "开通", "新开户", "医保编号", "新成立", "单位编号", "缴费", "续费", "转账", "订单编码", "绑定", "到期", "密码", "忘记密码", "修改密码", "发票", "专票"};
    public static final String WX_ANSWER_LEVEL1_TRUE = "Hi，您在说什么，小E没听懂……您是不是要咨询以下问题：\n" +
            "1.E点通账户注册开通\n" +
            "2.获取单位编号及密码\n" +
            "3.绑定账户or到期查询\n" +
            "4.E点通用户缴费续费\n" +
            "5.转账缴费问题\n" +
            "6.忘记密码or修改密码\n" +
            "7.发票寄送详情\n" +
            "请输入对应题号查看答案~";
    public static final String WX_ANSWER_LEVEL1_FALSE="呃…您的问题难道小E了，要不换个方法和姿势再试一次？\n" +
            "您也可以拨打4009988988进入我们的人工服务~";
    public static final String WX_ANSWER_LEVEL2="\n" +
            "本次回复解决您的疑问了吗？\n" +
            "解决or未解决";
    public static final String WX_ANSWER_LEVEL2_1="E点通账户注册开通方式：\n" +
            "1.前往官网登录模块右上方的“注册开通”；\n" +
            "2.填写单位编号、纳税人识别号及开通密码等信息后提交，即可完成开通。"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_2="E点通单位编号获取方式：\n" +
            "1.通过电话或QQ联系客服，告知客服所属单位的单位名称等信息；\n" +
            "2.经客服审核确认后，客服会立即告知您相应的单位编号及开通密码。"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_3="1.点击“我的账户”菜单\n" +
            "2.选择“绑定账户”子菜单进行绑定。\n" +
            "3.绑定成功后，点击“我的账户”菜单中的“到期时间”子菜单，即可获得相应的到期时间，也可直接在“账户信息”中查看。"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_4="E点通缴费方式如下：\n" +
            "1.前往E点通官网下单购买；\n" +
            "2.点击本公众号的“缴费”菜单进行购买续费。"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_5="线下转账缴费步骤如下：\n" +
            "1.前往E点通官网进行线上下单；\n" +
            "2.提交订单时，选择“线下转账”；\n" +
            "3.订单编码将通过短信发送给您，请在银行转账时在备注栏准确填写；\n" +
            "4.转账信息如下：\n" +
            "开户银行：兴业银行厦门东区支行\n" +
            "公司名称：易联众民生（厦门）科技有限公司\n" +
            "银行账号：129 500 100 100 297 762"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_6="若您已忘记原密码，请联系客服（4009988988）为您修改，若您还记得原密码，可通过以下任一方式修改：\n" +
            "1.在本公众号上进行修改，前往“我的账户”菜单>>选择“账户信息”子菜单>>点击“修改密码”；\n" +
            "2.登录官网进行修改，选择“账户信息”菜单>>点击“登录密码修改”进行密码重置。"+WX_ANSWER_LEVEL2;
    public static final String WX_ANSWER_LEVEL2_7="1.电子发票将在订单生效的10个工作日内寄往您所指定的邮箱；\n" +
            "2.普通发票将在订单生效后的20个工作日内寄往您所指定的收件地址。请您耐心等待~"+WX_ANSWER_LEVEL2;

    public static final String WX_ANSWER_HAPPY_END="感谢您对小E的肯定，如有其它问题可继续提问喔~";
    public static final String WX_ANSWER_BAD_END="很抱歉，小E暂时无法解决您的疑问，您可拨打4009988988咨询我们的人工客服，小E也会努力加油，争取下次让您满意~";

    //欢迎语
    public static final String WX_WELCOME = "欢迎关注E点通，E点通是最方便快捷的网上医保申报平台。目前服务已覆盖福建各县区超过100,000家单位。\n" +
            "->[<a href=\"http://"+BaseUrls.BASE_WEB+"#/ReServerInfo\">立即购买</a>]老用户点击这里缴费续费\n" +
            "->[<a href=\"http://"+BaseUrls.BASE_WEB+"#/OpenGuide\">开通指南</a>]新用户要先点击这里开通哦~\n" +
            "->[<a href=\"http://"+BaseUrls.BASE_WEB+"#/Activity\">优惠活动</a>]查看最新优惠\n" +
            "->[<a href=\"http://"+BaseUrls.BASE_WEB+"#/ReMine\">常见问题</a>]查看常见问题解答\n" +
            "->[<a href=\"http://"+BaseUrls.BASE_WEB+"#/FeedBack\">意见反馈</a>]提出您宝贵的意见";
}
