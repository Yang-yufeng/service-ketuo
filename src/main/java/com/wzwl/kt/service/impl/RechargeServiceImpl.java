package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.*;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RechargeServiceImpl
 * @Description TODO
 * @Author huff
 * @Date 2020/11/12 18:24
 * @Version 1.0
 */
@Service
@Slf4j
public class RechargeServiceImpl implements RechargeService {   //todo    返回值需要封装

    @Override
    public String getRechargeRules(RechargeRuleInfoDTO rechargeRuleInfoDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(rechargeRuleInfoDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_RECHARGE_RULES,params);
        ResultEntity entity = new ResultEntity(ResultEnum.SUCCESS);
        entity.setData(response);
        return entity.toString();
    }


    @Override
    public String getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(payCarCardFeeDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.PAY_CAR_CARD_FEE,params);

        ResultEntity entity = new ResultEntity(ResultEnum.SUCCESS);
        entity.setData(response);
        return entity.toString();
    }

    @Override
    public String getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(fixedCarChargeRecordDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FIXED_CAR_RECHARGE_INFO,params);

        ResultEntity entity = new ResultEntity(ResultEnum.SUCCESS);
        entity.setData(response);
        return entity.toString();

    }

    @Override
    public String postCarCardChargeInfo(String appId,  Integer parkId, Integer cardId,
                                        String orderNo, Integer carType, Integer payChannel, Integer chargeMethod, Integer chargeNumber,
                                        Integer amount, Integer freeNumber, String validFrom, String validTo, String createTime, String remark,
                                        Integer rechargeType, Integer operationType, String operator, String paySource) {
        //参数封装
        JSONObject params = new JSONObject();
        params.put("parkId",parkId);
        params.put("appId",appId);
        /*params.put("key",key);
        params.put("serviceCode",serviceCode);
        params.put("ts",ts);
        params.put("reqId",reqId);*/
        params.put("cardId",cardId);
        params.put("orderNo",orderNo);
        params.put("carType",carType);
        params.put("payChannel",payChannel);
        params.put("chargeMethod",chargeMethod);
        params.put("chargeNumber",chargeNumber);
        params.put("amount",amount);
        params.put("freeNumber",freeNumber);
        params.put("validFrom",validFrom);
        params.put("validTo",validTo);
        params.put("createTime",createTime);
        params.put("remark",remark);
        params.put("rechargeType",rechargeType);
        params.put("operationType",operationType);
        params.put("operator",operator);
        params.put("paySource",paySource);

        //先查询企业以及配置信息
        log.info("接收到车场固定车充值信息上报");
        log.info("上报参数为【{}】",params.toJSONString());
        Map<String, Object> paramMap=new HashMap<String, Object>();
        paramMap.put("configValue", params.get("appId"));
        String response=HttpUtil.doPostRequest(RequestUrlConstants.GET_CONFIG_URL, paramMap);
        JSONObject infoResponseJson=JSONObject.parseObject(response);
        boolean isSuccess=infoResponseJson.getBoolean("success");
        if (!isSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.CONFIG_NOT_EXISTED);
            return result.toString();
        }
        JSONObject data=infoResponseJson.getJSONObject("data");
        log.info("查询企业配置信息成功，为【{}】",data.toJSONString());
        String companyId=data.getString("companyId");
        JSONObject configJson=data.getJSONObject("configInfo");
        String appSecret=configJson.getString("appSecret");
        log.info("开始将数据上报到上层应用");

        //再将数据上报到上层应用
        JSONObject reportJson = new JSONObject();
        reportJson.putAll(params);
        reportJson.put("companyId",companyId);
        System.out.println(reportJson);
        log.info("上报地址为【{}】，上报参数为【{}】",RequestUrlConstants.POST_FIXED_CAR_CHARGE_RECORDS,reportJson);

        //Map maps = (Map) JSON.parse(reportJson.toString());

        //String reportResponse=HttpUtil.doPostRequest(RequestUrlConstants.POST_FIXED_CAR_CHARGE_RECORDS, maps);
        String reportResponse=HttpUtil.doPostRequestJson(RequestUrlConstants.POST_FIXED_CAR_CHARGE_RECORDS, reportJson);
        JSONObject reportResponseJson=JSONObject.parseObject(reportResponse);
        boolean reportSuccess=reportResponseJson.getBoolean("success");
        if (!reportSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.DATA_REPORT_ERROR);
            return result.toString();
        }
        ResultEntity result=new ResultEntity(ResultEnum.SUCCESS);
        return result.toString();
    }



}
