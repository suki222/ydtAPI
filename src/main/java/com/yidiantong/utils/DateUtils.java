package com.yidiantong.utils;

/**
 * Created by wujw on 17/5/9.
 */
public class DateUtils {

    /**
     * 时间格式匹配
     * @param date
     * @return YY年MM月DD日
     */
    public static String format(String date){
        return date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6,8)+"日";
    }
}
