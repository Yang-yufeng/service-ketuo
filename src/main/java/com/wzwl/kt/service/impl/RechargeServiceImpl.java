package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.*;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
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
public class RechargeServiceImpl implements RechargeService {   //todo    返回值需要封装

    @Override
    public String getRechargeRules(RechargeRuleInfoDTO rechargeRuleInfoDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(rechargeRuleInfoDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_RECHARGE_RULES,params);

        return response;
    }


    @Override
    public String getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(payCarCardFeeDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.Pay_Car_Card_Fee,params);

        return response;
    }

    @Override
    public String getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordDTO) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(fixedCarChargeRecordDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FIXED_CAR_RECHARGE_INFO,params);

        return response;

    }

    @Override
    public String postCarCardChargeInfo(JSONObject jsonParams) {
        //先查询企业以及配置信息
        Map<String, Object> paramMap=new HashMap<String, Object>();
        paramMap.put("configValue", jsonParams.get("appId"));
        String response=HttpUtil.doPostRequest(RequestUrlConstants.GET_CONFIG_URL, paramMap);
        JSONObject infoResponseJson=JSONObject.parseObject(response);
        boolean isSuccess=infoResponseJson.getBoolean("success");
        if (!isSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.CONFIG_NOT_EXISTED);
            return result.toString();
        }

        JSONObject data=infoResponseJson.getJSONObject("data");
        String companyId=data.getString("companyId");
        JSONObject configJson=data.getJSONObject("configInfo");
        String appSecret=configJson.getString("appSecret");

        //todo   需要进行key值验证

        //再将数据上报到上层应用
        JSONObject reportJson = new JSONObject();
        reportJson.putAll(jsonParams);
        reportJson.put("companyId",companyId);

        String reportResponse=HttpUtil.doPostRequest(RequestUrlConstants.POST_FIXED_CAR_CHARGE_RECORDS, reportJson);
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
