package com.yidiantong.enums;

/**
 * Created by wujw on 17/4/24.
 */
public enum BaseCode {
    SUCCESS("000000","结果正确"),
    ERROR_NODATA("222222","没有数据"),
    ERROR_PARAMETER("111111","参数错误"),
    ERROR_ACCESSTOKEN("777777","access_token错误"),
    ERROR_NOFOUND("400404","404错误"),
    ERROR("999999","未知错误"),
    ERROR_EXIST("400409","已存在"),
    AUTH_NOLOGIN("100001","未登录"),
    AUTH_LOGIN_ERROR("100002","登录错误"),
    AUTH_REGISTER_ERROR("100003","注册错误"),
    AUTH_NOUSER("100011","该用户未注册"),
    AUTH_HAVEUSER("100012","该用户已注册"),
    AUTH_ACCOUNTPASSWORD_ERROR("100005","账号或密码错误");

    private String code;
    private String message;

    BaseCode (String code,String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
