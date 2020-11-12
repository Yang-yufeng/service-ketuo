package com.wzwl.kt.service;


import com.wzwl.kt.dto.DeviceReqDTO;
import com.wzwl.kt.dto.ParkingLotReqDTO;
import com.wzwl.kt.dto.PassageReqDTO;
import org.springframework.validation.annotation.Validated;

import java.text.ParseException;

/**
 * @ClassName ParkingLotService
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/2 16:32
 * @Version 1.0
 */
public interface ParkingLotService {

    /**
     * 车辆进场上报
     *
     * @param appId      应用ID
     * @param key        加密串
     * @param parkId     停车场ID
     * @param ts         时间戳
     * @param reqId      请求ID
     * @param trafficId  进出场记录ID
     * @param entryTime  进场时间
     * @param carType    卡片类型
     * @param entryPlace 入口名称
     * @param imgName    图片名称
     * @param plateNo    车牌号
     * @param cardNo     无牌车卡号
     * @param freeLots   空闲车位
     * @param totalLots  总车位
     * @return
     * @throws ParseException 格式化异常
     */
    String carInReport(String appId, String key, Integer parkId, String ts, String reqId, String trafficId, String entryTime, Integer carType,
                       String entryPlace, String imgName, String plateNo, String cardNo, Integer freeLots, Integer totalLots) throws ParseException;

    /**
     * 车辆出场上报
     *
     * @param appId      应用ID
     * @param key        加密串
     * @param parkId     停车场ID
     * @param ts         时间戳
     * @param reqId      请求ID
     * @param trafficId  进出场记录ID
     * @param entryTime  进场时间
     * @param leaveTime  出场时间
     * @param carType    卡片类型
     * @param leavePlace 出口名
     * @param imgName    图片名称
     * @param freeLots   空闲车位
     * @param totalLots  总车位
     * @param plateNo    车牌号
     * @param cardNo     无牌车卡号
     * @return
     * @throws ParseException 格式化异常
     */
    String carOutReport(String appId, String key, Integer parkId, String ts, String reqId, String trafficId, String entryTime, String leaveTime,
                        Integer carType, String leavePlace, String imgName, Integer freeLots, Integer totalLots, String plateNo, String cardNo) throws ParseException;

    /**
     * 收费记录上报
     *
     * @param appId     应用ID
     * @param key       加密串
     * @param parkId    停车场ID
     * @param ts        时间戳
     * @param reqId     请求ID
     * @param entryTime 进场时间
     * @param payTime   支付时间
     * @param paidMoney 支付金额
     * @param plateNo   车牌号
     * @param cardNo    无牌车卡号
     * @return
     * @throws ParseException 格式化异常
     */
    String carChargeReport(String appId, String key, Integer parkId, String ts, String reqId, String entryTime, String payTime, Integer paidMoney,
                           String plateNo, String cardNo) throws ParseException;

    /**
     *通道信息查询
     * @param passageReqDTO 封装通道信息请求对象
     * @return
     */
    String listPassages(PassageReqDTO passageReqDTO);

    /**
     * 设备信息查询
     * @param deviceRequestDTO 封装设备信息请求对象
     * @return
     */
    String listDevices(DeviceReqDTO deviceRequestDTO);


    /**
     * 设备状态上报
     * @param appId      应用ID
     * @param key        加密串
     * @param parkId     停车场ID
     * @param ts         时间戳
     * @param reqId      请求ID
     * @param deviceCode 设备编码
     * @param deviceIp 设备IP
     * @param deviceName 设备名
     * @param deviceType 设备类型
     * @param status 设备状态
     * @param remark 故障描述
     * @param statusTime 故障/恢复时间
     * @return
     */
    String deviceStateReport(String appId, String key, Integer parkId, String ts, String reqId,String deviceCode,String deviceIp,String deviceName,
                             Integer deviceType,String status,String remark,String statusTime);

    /**
     *
     * @param parkingLotReqDTO  封装停车场信息请求对象
     * @return
     */
    String listParkingLots(@Validated ParkingLotReqDTO parkingLotReqDTO);
}
