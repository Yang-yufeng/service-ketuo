package com.wzwl.kt.service;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;

/**
 * @author huff
 * @date 2020/11/12 14:31
 */
public interface RechargeService {

    /**
     * 获取充值规则
     * @param rechargeRuleInfoDTO
     * @return
     */
    String getRechargeRules(RechargeRuleInfoDTO rechargeRuleInfoDTO);

    /**
     * 固定车充值接口
     * @param payCarCardFeeDTO
     * @return
     */
    String getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO);


    /**
     * 查询固定车充值记录
     * @param fixedCarChargeRecordVo
     * @return
     */
    String getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordVo);
}
