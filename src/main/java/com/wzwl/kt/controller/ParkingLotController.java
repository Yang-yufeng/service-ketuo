package com.wzwl.kt.controller;


import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.service.ParkingLotService;
import com.wzwl.kt.dto.DeviceReqDTO;
import com.wzwl.kt.dto.ParkingLotReqDTO;
import com.wzwl.kt.dto.PassageReqDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

/**
 * @ClassName ParkingLotController
 * @Description 停车场相关API
 * @Author yangwu
 * @Date 2020/11/2 16:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/v1")
public class ParkingLotController {


    @Resource
    private ParkingLotService parkingLotService;


    /**
     * 车辆进场上报
     * @return
     * @throws ParseException 格式化异常
     */
    @RequestMapping("/PostCarInInfo")
    public String carInReport(HttpServletRequest request) throws ParseException, IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        String param= null;
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        param= jsonObject.toJSONString();
        System.out.println("车辆进场上报");
        System.out.println("上报参数================="+param);
        String appId=jsonObject.getString("appId");
        String key=jsonObject.getString("key");
        Integer parkId=jsonObject.getInteger("parkId");
        String ts=jsonObject.getString("ts");
        String reqId=jsonObject.getString("reqId");
        String trafficId=jsonObject.getString("trafficId");
        String entryTime=jsonObject.getString("entryTime");
        Integer carType=jsonObject.getInteger("carType");
        String entryPlace=jsonObject.getString("entryPlace");
        String imgName=jsonObject.getString("imgName");
        String plateNo=jsonObject.getString("plateNo");
        String cardNo=jsonObject.getString("cardNo");
        Integer freeLots=jsonObject.getInteger("freeLots");
        Integer totalLots=jsonObject.getInteger("totalLots");
        Integer passType=jsonObject.getInteger("passType");
        String passRemark=jsonObject.getString("passRemark");
        return parkingLotService.carInReport(appId, key, parkId, ts, reqId, trafficId, entryTime, carType, entryPlace, imgName, plateNo,
                cardNo, freeLots!=null?freeLots:0, totalLots!=null?totalLots:0,passType,passRemark);
    }

    /**
     * 车辆出场上报
     * @return
     * @throws ParseException 格式化异常
     */
    @RequestMapping("/PostCarOutInfo")
    public String carOutReport( HttpServletRequest request) throws ParseException, IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        String param= null;
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        param= jsonObject.toJSONString();
        System.out.println("车辆出场上报");
        System.out.println("上报参数================="+param);
        String appId=jsonObject.getString("appId");
        String key=jsonObject.getString("key");
        Integer parkId=jsonObject.getInteger("parkId");
        String ts=jsonObject.getString("ts");
        String reqId=jsonObject.getString("reqId");
        String trafficId=jsonObject.getString("trafficId");
        String plateNo=jsonObject.getString("plateNo");
        String cardNo=jsonObject.getString("cardNo");
        String entryTime=jsonObject.getString("entryTime");
        String leaveTime=jsonObject.getString("leaveTime");
        Integer carType=jsonObject.getInteger("carType");
        String leavePlace=jsonObject.getString("leavePlace");
        String imgName=jsonObject.getString("imgName");
        Integer freeLots=jsonObject.getInteger("freeLots");
        Integer totalLots=jsonObject.getInteger("totalLots");
        Integer passType=jsonObject.getInteger("passType");
        String passRemark=jsonObject.getString("passRemark");
        return parkingLotService.carOutReport(appId, key, parkId, ts, reqId, trafficId, entryTime, leaveTime, carType, leavePlace, imgName,
                freeLots!=null?freeLots:0, totalLots!=null?totalLots:0, plateNo, cardNo,passType,passRemark);
    }

    /**
     * 收费记录上报
     * @return
     * @throws ParseException 格式化异常
     */
    @RequestMapping("/PostPayFeeInfo")
    public String carChargeReport( HttpServletRequest request) throws ParseException, IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        String param= null;
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        param= jsonObject.toJSONString();
        System.out.println("车辆缴费上报");
        System.out.println("上报参数================="+param);
        String appId=jsonObject.getString("appId");
        String key=jsonObject.getString("key");
        Integer parkId=jsonObject.getInteger("parkId");
        String ts=jsonObject.getString("ts");
        String reqId=jsonObject.getString("reqId");
        String entryTime=jsonObject.getString("entryTime");
        String payTime=jsonObject.getString("payTime");
        Integer paidMoney=jsonObject.getInteger("paidMoney");
        String plateNo=jsonObject.getString("plateNo");
        String cardNo=jsonObject.getString("cardNo");
        return parkingLotService.carChargeReport(appId, key, parkId, ts, reqId, entryTime, payTime, paidMoney, plateNo, cardNo);
    }

    /**
     * 设备状态上报
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/PostDeviceState")
    public String deviceStateReport(HttpServletRequest request) throws IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        String param= null;
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        System.out.println("设备状态上报");
        System.out.println("上报参数================="+jsonObject);
        String appId=jsonObject.getString("appId");
        String key=jsonObject.getString("key");
        Integer parkId=jsonObject.getInteger("parkId");
        String ts=jsonObject.getString("ts");
        String reqId=jsonObject.getString("reqId");
        String deviceCode=jsonObject.getString("deviceCode");
        String deviceIp=jsonObject.getString("deviceIp");
        String deviceName=jsonObject.getString("deviceName");
        Integer deviceType=jsonObject.getInteger("deviceType");
        String status=jsonObject.getString("status");
        String remark=jsonObject.getString("remark");
        String statusTime=jsonObject.getString("statusTime");
        return parkingLotService.deviceStateReport(appId,key,parkId,ts,reqId,deviceCode,deviceIp,deviceName,deviceType,status,remark,statusTime );
    }


    /**
     * 获取停车场信息
     * @param parkingLotReqDTO 封装停车场信息请求对象
     * @return
     */
    @RequestMapping("/listParkingLots")
    public String listParkingLots(@Validated ParkingLotReqDTO parkingLotReqDTO){
        return parkingLotService.listParkingLots(parkingLotReqDTO);
    }

   /* *//**
     * 获取停车场通道信息
     * @param passageReqDTO 封装通道信息请求对象
     * @return
     *//*
    @RequestMapping("/listPassages")
    public String listPassages(@Validated PassageReqDTO passageReqDTO){
        return parkingLotService.listPassages(passageReqDTO);
    }
*/
    /**
     * 获取停车场设备信息
     * @param deviceRequestVO 封装设备信息请求对象
     * @return
     */
    @RequestMapping("/listDevices")
    public String listDevices(@Validated DeviceReqDTO deviceRequestVO){
        return parkingLotService.listDevices(deviceRequestVO);
    }






    /**
     * ping测试
     *
     * @return
     */
    @RequestMapping("/ping")
    public String ping() {

        return "Ping Success!";
    }




}
