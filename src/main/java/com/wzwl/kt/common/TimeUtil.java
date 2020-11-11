package com.wzwl.kt.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeUtil
 * @Description 时间处理工具类
 * @Author yangwu
 * @Date 2020/11/6 14:20
 * @Version 1.0
 */
public class TimeUtil {


    public static int dateToStamp(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date=simpleDateFormat.parse(dateString);
        return (int) (date.getTime() / 1000);
    }

    public static String stampToDate(long timestamp, String format) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date=new Date(timestamp);
        return simpleDateFormat.format(date);
    }
}
