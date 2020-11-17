package com.wzwl.kt.service;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;

/**
 * @ClassName RechargeService
 * @Description TODO
 * @Author huff
 * @Date 2020/11/12 18:24
 * @Version 1.0
 */
public interface RechargeService {

    /**
     * 获取充值规则
     * @param rechargeRuleInfoDTO
     * @return
     */
    ResultEntity getRechargeRules(RechargeRuleInfoDTO rechargeRuleInfoDTO);

    /**
     * 固定车充值接口
     * @param payCarCardFeeDTO
     * @return
     */
    ResultEntity getFixedCarInfo(PayCarCardFeeDTO payCarCardFeeDTO);


    /**
     * 查询固定车充值记录
     * @param fixedCarChargeRecordVo
     * @return
     */
    ResultEntity getChargeRecords(FixedCarChargeRecordDTO fixedCarChargeRecordVo);

    /**
     * 车场固定车充值信息上报
     * @param params
     * @return
     */
    ResultEntity postCarCardChargeInfo(JSONObject params);
}
