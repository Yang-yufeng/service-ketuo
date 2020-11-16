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


    /**
     * 时间转化成时间戳
     * @param dateString 格式化时间
     * @param format 格式（yyyy-MM-dd HH:mm:ss）
     * @return
     * @throws ParseException
     */
    public static int dateToStamp(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date=simpleDateFormat.parse(dateString);
        return (int) (date.getTime() / 1000);
    }

    /**
     * 时间戳转化为时间
     * @param timestamp 时间戳
     * @param format 格式（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String stampToDate(long timestamp, String format) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date=new Date(timestamp);
        return simpleDateFormat.format(date);
    }
}
