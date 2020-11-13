package com.wzwl.kt.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.dto.FixedCarChargeRecordDTO;
import com.wzwl.kt.dto.PayCarCardFeeDTO;
import com.wzwl.kt.dto.RechargeRuleInfoDTO;
import com.wzwl.kt.service.RechargeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName RechargeController
 * @Description 充值相关api
 * @author huff
 * @date 2020/11/12 14:29
 * @Version 1.0
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

    /**
     * 车场固定车充值信息上报
     * @param jsonParams
     * @return
     */
    @RequestMapping(value = "/PostCarCardChargeInfo",method = RequestMethod.POST)
    public String postCarCardChargeInfo(@RequestParam JSONObject jsonParams){

        return rechargeService.postCarCardChargeInfo(jsonParams);

    }


}
