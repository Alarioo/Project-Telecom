package com.alario.ct.common.util;

import java.text.DecimalFormat;

/**
 * 数字工具类
 * @author alario
 */
public class NumberUtil {
    //格式化通话时长
    public static String format (long num,int length){
        StringBuilder sb =new StringBuilder();
        for (int i =0;i<length;i++){
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat(sb.toString());
        return df.format(num);
    }
}
