package com.wzwl.kt.controller;

import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 充值相关api
 * @author huff
 * @date 2020/11/12 14:29
 */
@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Resource
    private RechargeService rechargeService;

    /**
     * 获取充值规则
     * @param rechargeRuleInfoDTO
     * @return
     */
    @RequestMapping(value = "/getRechargeRules",method = RequestMethod.POST)
    public String getRechargeRules(@RequestBody @Validated RechargeRuleInfoDTO rechargeRuleInfoDTO){

        return rechargeService.getRechargeRules(rechargeRuleInfoDTO);

    }

    /**
     * 充值
     * @param payCarCardFeeDTO
     * @return
     */
    @RequestMapping(value = "/getFixedCarInfo",method = RequestMethod.POST)
    public String getFixedCarInfo(@RequestBody @Validated PayCarCardFeeDTO payCarCardFeeDTO){

        return rechargeService.getFixedCarInfo(payCarCardFeeDTO);

    }


    /**
     * 查询固定车充值记录
     * @param fixedCarChargeRecordDTO
     * @return
     */
    @RequestMapping(value = "/getChargeRecords",method = RequestMethod.POST)
    public String getChargeRecords(@RequestBody @Validated FixedCarChargeRecordDTO fixedCarChargeRecordDTO){

        return rechargeService.getChargeRecords(fixedCarChargeRecordDTO);

    }


}
