package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
import org.springframework.stereotype.Service;

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
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(rechargeRuleInfoDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_RECHARGE_RULES,params);

        return response;
    }


    @Override
    public String getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(payCarCardFeeDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.Pay_Car_Card_Fee,params);

        return response;
    }

    @Override
    public String getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(fixedCarChargeRecordDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FIXED_CAR_CHARGE_RECORDS,params);

        return response;
    }


    //todo  充值信息上报


}
