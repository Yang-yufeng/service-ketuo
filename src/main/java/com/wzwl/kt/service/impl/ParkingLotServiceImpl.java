package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.*;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.service.ParkingLotService;
import com.wzwl.kt.dto.DeviceReqDTO;
import com.wzwl.kt.dto.ParkingLotReqDTO;
import com.wzwl.kt.dto.PassageReqDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName ParkingLotServiceImpl
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/2 16:33
 * @Version 1.0
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {


    @Override
    public String carInReport(String appId, String key, Integer parkId, String ts, String reqId, String trafficId, String entryTime, Integer carType,
                              String entryPlace, String imgName, String plateNo, String cardNo, Integer freeLots, Integer totalLots,Integer passType,
                              String passRemark) throws ParseException {
        plateNo=(plateNo != null && !"".equals(plateNo)) ? plateNo : null;
        cardNo=(cardNo != null && !"".equals(cardNo)) ? cardNo : null;
        //先查询企业以及配置信息
        Map<String, Object> infoMap=new HashMap<>(16);
        infoMap.put("configValue", appId);
        String response=HttpUtil.doPostRequest(RequestUrlConstants.GET_CONFIG_URL, infoMap);
        JSONObject infoResponseJson=JSONObject.parseObject(response);
        boolean isSuccess=infoResponseJson.getBoolean("success");
        if (!isSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.CONFIG_NOT_EXISTED);
            return result.toString();
        }
        // {"code":0,"data":{"companyId":"zz","configInfo":{"appId":"appIdzz","appSecret":"appSecretzz",
        //        "imageApi":"imageApizz"}},"msg":"操作成功","success":true}
        JSONObject data=infoResponseJson.getJSONObject("data");
        String companyId=data.getString("companyId");
        JSONObject configJson=data.getJSONObject("configInfo");
        String appSecret=configJson.getString("appSecret");
        //调用科拓api获取图片信息,若获取失败继续上报
        String imgUrl=null;
        //获取图片信息
        System.out.println("开始获取图片信息=================");
        try {
            JSONObject imageJson=new JSONObject();
            imageJson.put("appId", appId);
            imageJson.put("parkId", parkId);
            imageJson.put("serviceCode", "getParkingImg");
            imageJson.put("ts", System.currentTimeMillis() + "");
            imageJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
            imageJson.put("imgName", imgName);
            imageJson.put("type", 1);
            String imageKey=SignUtil.paramsSign(imageJson, appSecret);
            imageJson.put("key", imageKey);
            String imageResponse=HttpUtil.doPostRequestJson(RequestUrlConstants.GET_IMAGE_URL, imageJson);
            JSONObject imageResponseJson=JSONObject.parseObject(imageResponse);
            imgUrl=imageResponseJson.getJSONObject("data").getString("imgUrl");
            System.out.println("图片返回结果=================" + imgUrl);
        } catch (Exception e) {
            System.out.println("图片获取失败------数据继续上报");
        }
        //查询车位情况
        //System.out.println("开始获取车位信息=================");
        JSONObject freeLotsParamJson=new JSONObject();
        freeLotsParamJson.put("appId", "10156");
        freeLotsParamJson.put("parkId", 115);
        freeLotsParamJson.put("serviceCode", "getFreeSpaceNum");
        freeLotsParamJson.put("ts", System.currentTimeMillis() + "");
        freeLotsParamJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
        freeLotsParamJson.put("isFindCarSys", 0);
        String freeLotsKey=SignUtil.paramsSign(freeLotsParamJson, "cba9dccc39e247c6afe53157b96422b2");
        freeLotsParamJson.put("key", freeLotsKey);
        //System.out.println("请求参数======================"+freeLotsParamJson);
        String freeLotsResponse=HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FREE_LOTS_URL, freeLotsParamJson);
        // System.out.println("车位数请求结果===================="+freeLotsResponse);
        JSONObject freeLotsResponseJson=JSONObject.parseObject(freeLotsResponse);
        JSONObject dataJson=freeLotsResponseJson.getJSONObject("data");
        totalLots=dataJson.getInteger("totalNum");
        freeLots=dataJson.getInteger("freeSpaceNum");
        //System.out.println("总车位数====================="+totalLots);
        //System.out.println("空闲车位数====================="+freeLots);
        //再将数据上报到上层应用
        ///entryTime要转换成时间戳格式
        Map<String, Object> reportMap=new HashMap<String, Object>();
        reportMap.put("companyId", companyId);
        reportMap.put("parkId", parkId);
        reportMap.put("carNo", plateNo);
        reportMap.put("cardNo", cardNo);
        reportMap.put("entryTime", TimeUtil.dateToStamp(entryTime, "yyyy-MM-dd HH:mm:ss"));
        reportMap.put("entryName", entryPlace);
        reportMap.put("cardType", carType);
        reportMap.put("entryImage", imgUrl);
        reportMap.put("useSpace", totalLots - freeLots);
        reportMap.put("entryPassType",passType);
        reportMap.put("entryPassRemark",passRemark);
        String reportResponse=HttpUtil.doPostRequest(RequestUrlConstants.CAR_IN_REPORT_URL, reportMap);
        JSONObject reportResponseJson=JSONObject.parseObject(reportResponse);
        boolean reportSuccess=reportResponseJson.getBoolean("success");
        if (!reportSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.DATA_REPORT_ERROR);
            return result.toString();
        }
        ResultEntity result=new ResultEntity(ResultEnum.SUCCESS);
        return result.toString();
    }

    @Override
    public String carOutReport(String appId, String key, Integer parkId, String ts, String reqId, String trafficId, String entryTime, String leaveTime,
                               Integer carType, String leavePlace, String imgName, Integer freeLots, Integer totalLots, String plateNo, String cardNo,
                               Integer passType, String passRemark) throws ParseException {
        plateNo=(plateNo != null && !"".equals(plateNo)) ? plateNo : null;
        cardNo=(cardNo != null && !"".equals(cardNo)) ? cardNo : null;
        //先查询企业以及配置信息
        Map<String, Object> infoMap=new HashMap<String, Object>();
        infoMap.put("configValue", appId);
        String response=HttpUtil.doPostRequest(RequestUrlConstants.GET_CONFIG_URL, infoMap);
        JSONObject infoResponseJson=JSONObject.parseObject(response);
        boolean isSuccess=infoResponseJson.getBoolean("success");
        if (!isSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.CONFIG_NOT_EXISTED);
            return result.toString();
        }
        // {"code":0,"data":{"companyId":"zz","configInfo":{"appId":"appIdzz","appSecret":"appSecretzz",
        //        "imageApi":"imageApizz"}},"msg":"操作成功","success":true}
        JSONObject data=infoResponseJson.getJSONObject("data");
        String companyId=data.getString("companyId");
        JSONObject configJson=data.getJSONObject("configInfo");
        String appSecret=configJson.getString("appSecret");
        //调用科拓api获取图片信息,若获取失败继续上报
        String imgUrl=null;
        //获取图片信息
        System.out.println("开始获取图片信息=================");
        try {
            JSONObject imageJson=new JSONObject();
            imageJson.put("appId", appId);
            imageJson.put("parkId", parkId);
            imageJson.put("serviceCode", "getParkingImg");
            imageJson.put("ts", System.currentTimeMillis() + "");
            imageJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
            imageJson.put("imgName", imgName);
            imageJson.put("type", 1);
            String imageKey=SignUtil.paramsSign(imageJson, appSecret);
            imageJson.put("key", imageKey);
            String imageResponse=HttpUtil.doPostRequestJson(RequestUrlConstants.GET_IMAGE_URL, imageJson);
            JSONObject imageResponseJson=JSONObject.parseObject(imageResponse);
            imgUrl=imageResponseJson.getJSONObject("data").getString("imgUrl");
            System.out.println("图片返回结果=================" + imgUrl);
        } catch (Exception e) {
            System.out.println("图片获取失败------数据继续上报");
        }
        //查询车位情况
        //System.out.println("开始获取车位信息=================");
        JSONObject freeLotsParamJson=new JSONObject();
        freeLotsParamJson.put("appId", "10156");
        freeLotsParamJson.put("parkId", 115);
        freeLotsParamJson.put("serviceCode", "getFreeSpaceNum");
        freeLotsParamJson.put("ts", System.currentTimeMillis() + "");
        freeLotsParamJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
        freeLotsParamJson.put("isFindCarSys", 0);
        String freeLotsKey=SignUtil.paramsSign(freeLotsParamJson, "cba9dccc39e247c6afe53157b96422b2");
        freeLotsParamJson.put("key", freeLotsKey);
        //System.out.println("请求参数======================"+freeLotsParamJson);
        String freeLotsResponse=HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FREE_LOTS_URL, freeLotsParamJson);
        //System.out.println("车位数请求结果===================="+freeLotsResponse);
        JSONObject freeLotsResponseJson=JSONObject.parseObject(freeLotsResponse);
        JSONObject dataJson=freeLotsResponseJson.getJSONObject("data");
        totalLots=dataJson.getInteger("totalNum");
        freeLots=dataJson.getInteger("freeSpaceNum");
        //System.out.println("总车位数====================="+totalLots);
        //System.out.println("空闲车位数====================="+freeLots);
        //再将数据上报到上层应用
        Map<String, Object> reportMap=new HashMap<String, Object>();
        reportMap.put("companyId", companyId);
        reportMap.put("parkId", parkId);
        reportMap.put("carNo", plateNo);
        reportMap.put("cardNo", cardNo);
        reportMap.put("entryTime", TimeUtil.dateToStamp(entryTime, "yyyy-MM-dd HH:mm:ss"));
        reportMap.put("exitTime", TimeUtil.dateToStamp(leaveTime, "yyyy-MM-dd HH:mm:ss"));
        reportMap.put("exitName", leavePlace);
        reportMap.put("exitImage", imgUrl);
        reportMap.put("useSpace", totalLots - freeLots);
        reportMap.put("exitPassType",passType);
        reportMap.put("exitPassRemark",passRemark);
        String reportResponse=HttpUtil.doPostRequest(RequestUrlConstants.CAR_OUT_REPORT_URL, reportMap);
        JSONObject reportResponseJson=JSONObject.parseObject(reportResponse);
        boolean reportSuccess=reportResponseJson.getBoolean("success");
        if (!reportSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.DATA_REPORT_ERROR);
            return result.toString();
        }
        ResultEntity result=new ResultEntity(ResultEnum.SUCCESS);
        return result.toString();
    }

    @Override
    public String carChargeReport(String appId, String key, Integer parkId, String ts, String reqId, String entryTime, String payTime, Integer paidMoney, String plateNo, String cardNo) throws ParseException {
        plateNo=(plateNo != null && !"".equals(plateNo)) ? plateNo : null;
        cardNo=(cardNo != null && !"".equals(cardNo)) ? cardNo : null;
        //先查询企业以及配置信息
        Map<String, Object> infoMap=new HashMap<String, Object>();
        infoMap.put("configValue", appId);
        String response=HttpUtil.doPostRequest(RequestUrlConstants.GET_CONFIG_URL, infoMap);
        JSONObject infoResponseJson=JSONObject.parseObject(response);
        boolean isSuccess=infoResponseJson.getBoolean("success");
        if (!isSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.CONFIG_NOT_EXISTED);
            return result.toString();
        }
        // {"code":0,"data":{"companyId":"zz","configInfo":{"appId":"appIdzz","appSecret":"appSecretzz",
        //        "imageApi":"imageApizz"}},"msg":"操作成功","success":true}
        JSONObject data=infoResponseJson.getJSONObject("data");
        String companyId=data.getString("companyId");
        //再将数据上报到上层应用
        Map<String, Object> reportMap=new HashMap<String, Object>();
        reportMap.put("companyId", companyId);
        reportMap.put("parkId", parkId);
        reportMap.put("carNo", plateNo);
        reportMap.put("cardNo", cardNo);
        reportMap.put("entryTime", TimeUtil.dateToStamp(entryTime, "yyyy-MM-dd HH:mm:ss"));
        reportMap.put("payTime", TimeUtil.dateToStamp(payTime, "yyyy-MM-dd HH:mm:ss"));
        reportMap.put("payMoney", paidMoney);
        System.out.println(reportMap);
        String reportResponse=HttpUtil.doPostRequest(RequestUrlConstants.CAR_CHARGE_REPORT_URL, reportMap);
        JSONObject reportResponseJson=JSONObject.parseObject(reportResponse);
        boolean reportSuccess=reportResponseJson.getBoolean("success");
        System.out.println(reportResponseJson);
        if (!reportSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.DATA_REPORT_ERROR);
            return result.toString();
        }
        ResultEntity result=new ResultEntity(ResultEnum.SUCCESS);
        return result.toString();
    }

    @Override
    public String listPassages(PassageReqDTO passageReqDTO) {
        String result = HttpUtil.doPostRequestJson(RequestUrlConstants.GET_PASSAGES_URL, (JSONObject) JSONObject.toJSON(passageReqDTO));
        return  result;
    }

    @Override
    public String listDevices(DeviceReqDTO deviceRequestDTO) {
        String result = HttpUtil.doPostRequestJson(RequestUrlConstants.GET_DEVICES_URL, (JSONObject) JSONObject.toJSON(deviceRequestDTO));
        return  result;
    }

    @Override
    public String deviceStateReport(String appId, String key, Integer parkId, String ts, String reqId, String deviceCode, String deviceIp, String deviceName,
                                    Integer deviceType, String status, String remark, String statusTime) {
        return null;
    }

    @Override
    public String listParkingLots(ParkingLotReqDTO parkingLotReqDTO) {
        String result = HttpUtil.doPostRequestJson(RequestUrlConstants.GET_PARKINGLOTS_URL, (JSONObject) JSONObject.toJSON(parkingLotReqDTO));
        return  result;
    }


}
