package com.yidiantong.base;

/**
 * Created by wujw on 17/5/2.
 */
public class BaseUrls {
//    public static final String BASE="http://192.168.44.185:8080/edt-svc/";//内网测试地址
    public static final String BASE="http://edt-svc.edtsoft.com/edt-svc/";//外网测试地址

    //根据id获取用户信息
    public static final String URL_USER00=BASE+"user00/";
    //获取全部员工数目
    public static final String URL_USER00_LIST=BASE+"user00/number";
    //员工登录
    public static final String URL_USER00_LOGIN=BASE+"user00/login";
    //赠品列表
    public static final String URL_ZP_INFOS=BASE+"zpInfos";
    //订单接口
    public static final String URL_DDB000_LIST=BASE+"ddb000/";
    //提交订单
//    public static final String URL_DDB000_COMMIT=BASE+"ddb000/";
    //查询微信绑定信息
    public static final String URL_BDXXB0_QUERY=BASE+"bdxxb0/";
    //新增绑定信息
    public static final String URL_BDXXB0_ADD=BASE+"bdxxb0";
    //支付接口
    public static final String URL_PAYAPI_PAY="http://192.168.44.185:8080/payapi/payoff.shtml";

}
