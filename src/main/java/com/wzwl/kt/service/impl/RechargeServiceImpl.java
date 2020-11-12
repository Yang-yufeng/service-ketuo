package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.ResponseUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.service.RechargeService;
import com.wzwl.kt.vo.FixedCarChargeRecordVo;
import com.wzwl.kt.vo.PayCarCardFee;
import com.wzwl.kt.vo.RechargeRuleInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author huff
 * @date 2020/11/12 14:31
 */
@Service
public class RechargeServiceImpl implements RechargeService {


    @Override
    public String getRechargeRules(RechargeRuleInfoVo rechargeRuleInfoVo) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(rechargeRuleInfoVo));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_RECHARGE_RULES,params);

        return ResponseUtil.getResponse(response);
    }


    @Override
    public String getFixedCarInfo(PayCarCardFee payCarCardFee) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(payCarCardFee));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.Pay_Car_Card_Fee,params);

        return ResponseUtil.getResponse(response);
    }

    @Override
    public String getChargeRecords(FixedCarChargeRecordVo fixedCarChargeRecordVo) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(fixedCarChargeRecordVo));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_FIXED_CAR_CHARGE_RECORDS,params);

        return ResponseUtil.getResponse(response);
    }


}
