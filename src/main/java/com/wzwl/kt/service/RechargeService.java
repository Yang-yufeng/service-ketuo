package com.wzwl.kt.service;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.vo.FixedCarChargeRecordVo;
import com.wzwl.kt.vo.PayCarCardFee;
import com.wzwl.kt.vo.RechargeRuleInfoVo;

/**
 * @author huff
 * @date 2020/11/12 14:31
 */
public interface RechargeService {

    /**
     * 获取充值规则
     * @param rechargeRuleInfoVo
     * @return
     */
    String getRechargeRules(RechargeRuleInfoVo rechargeRuleInfoVo);

    /**
     * 固定车充值接口
     * @param payCarCardFee
     * @return
     */
    String getFixedCarInfo(PayCarCardFee payCarCardFee);


    /**
     * 查询固定车充值记录
     * @param fixedCarChargeRecordVo
     * @return
     */
    String getChargeRecords(FixedCarChargeRecordVo fixedCarChargeRecordVo);
}
