package com.wzwl.kt.enums;

/**
 * @author huff
 * @date 2020/11/12 15:17
 */
public enum  CarTypeEnum {

    TEMPORARY_CAR(0, "临时车"),

    VIP_CAR(1, "VIP车"),

    MONTHLY_RENT_CAR(2, "月租车"),

    RECHARGE_CAR(3, "充值车"),

    HOURLY_RENT_CAR(4, "时租车"),

    PROPERTY_CAR(5, "产权车"),

    COUNT_CAR(6, "计次车"),

    VIP_CARD(7, "贵宾卡"),

    EMPLOYEE_CARD(8, "员工卡"),

    COACH(9, "大客车"),

    BOOK_CAR(100, "预约车"),

    CUSTOMIZE(101, "自定义");   //todo   >100如何表示


    public int carTypeCode;

    public String carTypeName;

    private CarTypeEnum(int code,String codeDesc) {
        this.carTypeCode = code;
        this.carTypeName = codeDesc;
    }
}
