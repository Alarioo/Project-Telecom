package com.alario.ct.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author alario
 */
public class DateUtil {
    public static String format(Date date,String d2sformat){
        SimpleDateFormat sdf = new SimpleDateFormat(d2sformat);
        return sdf.format(date);
    }
    //将字符串按照指定格式解析为日期对象
    public static Date parse(String dateString,String s2dformat){
        SimpleDateFormat sdf = new SimpleDateFormat(s2dformat);
        Date date =null;
        try {
            date =sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
