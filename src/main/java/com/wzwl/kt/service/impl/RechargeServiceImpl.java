package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.ResponseUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
import org.springframework.stereotype.Service;

/**
 * @author huff
 * @date 2020/11/12 14:31
 */
@Service
public class RechargeServiceImpl implements RechargeService {


    @Override
    public String getRechargeRules(RechargeRuleInfoDTO rechargeRuleInfoDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(rechargeRuleInfoDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_RECHARGE_RULES,params);

        return ResponseUtil.getResponse(response);
    }


    @Override
    public String getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(payCarCardFeeDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.Pay_Car_Card_Fee,params);

        return ResponseUtil.getResponse(response);
    }

    @Override
    public String getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(fixedCarChargeRecordDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FIXED_CAR_CHARGE_RECORDS,params);

        return ResponseUtil.getResponse(response);
    }


}
