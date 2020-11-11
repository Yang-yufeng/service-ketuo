package com.wzwl.kt.common;


/**
 * @ClassName ResultEnum
 * @Description 返回信息枚举类
 * @Author yangwu
 * @Date 2020/10/22 18:07
 * @Version 1.0
 */
public enum ResultEnum {


    /**
     * 没有找到配置信息
     **/
    CONFIG_NOT_EXISTED(8001, "没有找到配置信息"),

    /**
     * 数据上报错误
     **/
    DATA_REPORT_ERROR(8002, "数据上报错误"),

    /**
     * 成功
     **/
    SUCCESS(0, "操作成功");

    public int code;

    public String msg;

    ResultEnum(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }
}
