package com.wzwl.kt.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.service.RechargeService;
import com.wzwl.kt.vo.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * @param rechargeRuleInfoVo
     * @return
     */
    @RequestMapping(value = "/getRechargeRules",method = RequestMethod.POST)
    public String getRechargeRules(@RequestBody @Validated RechargeRuleInfoVo rechargeRuleInfoVo){

        return rechargeService.getRechargeRules(rechargeRuleInfoVo);

    }

    /**
     * 充值
     * @param payCarCardFee
     * @return
     */
    @RequestMapping(value = "/getFixedCarInfo",method = RequestMethod.POST)
    public String getFixedCarInfo(@RequestBody @Validated PayCarCardFee payCarCardFee){

        return rechargeService.getFixedCarInfo(payCarCardFee);

    }


    /**
     * 查询固定车充值记录
     * @param fixedCarChargeRecordVo
     * @return
     */
    @RequestMapping(value = "/getChargeRecords",method = RequestMethod.POST)
    public String getChargeRecords(@RequestBody @Validated FixedCarChargeRecordVo fixedCarChargeRecordVo){

        return rechargeService.getChargeRecords(fixedCarChargeRecordVo);

    }

    /**
     *车场固定车充值信息上报
     * @param postCarCardChargeInfoVo
     * @return
     */
    @RequestMapping(value = "/postCarCardChargeInfo",method = RequestMethod.POST)
    public String postCarCardChargeInfo(@RequestBody PostCarCardChargeInfoVo postCarCardChargeInfoVo){
        return rechargeService.postCarCardChargeInfo(postCarCardChargeInfoVo);
    }


}
