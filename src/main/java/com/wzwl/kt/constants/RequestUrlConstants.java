package com.wzwl.kt.constants;


/**
 * @ClassName RequestUrlConstants
 * @Description 对接科拓停车场URL
 * @Author yangwu
 * @Date 2020/11/2 17:40
 * @Version 1.0
 */
public class RequestUrlConstants {


    /**
     * 获取配置信息
     */
    public static final String GET_CONFIG_URL="http://localhost:8001/config/get";

    /**
     * 车辆进场上报
     */
    public static final String CAR_IN_REPORT_URL="http://localhost:8001/v1/car_in";

    /**
     * 车辆出场上报
     */
    public static final String CAR_OUT_REPORT_URL="http://localhost:8001/v1/car_out";

    /**
     * 车辆缴费上报
     */
    public static final String CAR_CHARGE_REPORT_URL="http://localhost:8001/v1/car_charge";

    /**
     * 获取图片
     */
    public static final String GET_IMAGE_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingImg";

    /**
     * 获取空余车位
     */
    public static final String GET_FREE_LOTS_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetFreeSpaceNum";

    public static final String GET_AREA_INFO="http://IP:123/api/wec/GetParkingPlaceArea";

    public static final String GET_RECHARGE_RULES="http://IP:123/api/wec/GetCarCardRule";

    public static final String Pay_Car_Card_Fee="http://IP:123/api/wec/PayCarCardFee";

    public static final String GET_FIXED_CAR_CHARGE_RECORDS="http://IP:123/api/wec/GetCarCardChargeList";



    /**
     * 获取通道信息
     */
    public static final String GET_PASSAGES_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode";

    /**
     * 获取设备信息
     */
    public static final String GET_DEVICES_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode";

    /**
     * 获取停车场信息
     */
    public static final String GET_PARKINGLOTS_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode";

}
