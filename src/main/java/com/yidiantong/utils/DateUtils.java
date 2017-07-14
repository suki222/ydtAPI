package com.yidiantong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wujw on 17/5/9.
 */
public class DateUtils {
    Calendar now = Calendar.getInstance();


    /**
     * 时间格式匹配
     * @param date
     * @return YY年MM月DD日
     */
    public static String format(String date){
        return date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6,8)+"日";
    }

    /**
     * 获取当前时间
     * @return
     * @throws ParseException
     */
    public static String getDate() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }


}
