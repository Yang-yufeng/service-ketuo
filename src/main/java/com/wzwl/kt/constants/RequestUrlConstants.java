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
    public static final String CAR_IN_REPORT_URL="http://localhost:8001/v1/carIn";

    /**
     * 车辆出场上报
     */
    public static final String CAR_OUT_REPORT_URL="http://localhost:8001/v1/carOut";

    /**
     * 车辆缴费上报
     */
    public static final String CAR_CHARGE_REPORT_URL="http://localhost:8001/v1/carCharge";

    /**
     * 获取图片
     */
    public static final String GET_IMAGE_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingImg";

    /**
     * 获取空余车位
     */
    public static final String GET_FREE_LOTS_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetFreeSpaceNum";

    /**
     * 获取区域信息
     */
    public static final String GET_AREA_INFO="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingPlaceArea";

    /**
     * 获取充值规则
     */
    public static final String GET_RECHARGE_RULES="http://kp-open.keytop.cn/unite-api/api/wec/GetCarCardRule";

    /**
     * 固定车充值
     */
    public static final String PAY_CAR_CARD_FEE="http://kp-open.keytop.cn/unite-api/api/wec/PayCarCardFee";

    /**
     * 查询固定车充值信息
     */
    public static final String GET_FIXED_CAR_RECHARGE_INFO="http://kp-open.keytop.cn/unite-api/api/wec/GetCarCardChargeList";

    /**
     * 固定车充值信息上报
     */
    public static final String POST_FIXED_CAR_CHARGE_RECORDS="http://localhost:8001/recharge/reportRecords";

    /**
     * 获取通道信息
     */
    public static final String GET_PASSAGES_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode";

    /**
     * 获取设备信息
     */
    public static final String GET_DEVICES_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetDeviceList";

    /**
     * 获取停车场信息
     */
    public static final String GET_PARKING_LOTS_URL="http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode";

    /**
     * 获取空余车位数信息
     */
    public static final String GET_PARKING_SPACE="http://112.5.64.63:9099/api/find/GetFreeSpaceNum";

    /**
     * 查询车辆停放位置
     */
    public static final String GET_CAR_LOCATION="http://112.5.64.63:9099/api/find/GetCarLocList2";


}
