package com.wzwl.kt.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 固定车充值记录
 * @author huff
 * @date 2020/11/12 15:58
 */
@Data
public class FixedCarChargeRecordVo {

    /**
     *车牌号
     */
    @NotEmpty(message = "车牌号不能为空")
    private String plateNo;

    /**
     *充值开始时间
     */
    @NotEmpty(message = "充值开始时间不能为空")
    private String beginTime;


    /**
     *充值结束时间
     */
    @NotEmpty(message = "充值结束时间不能为空")
    private String endTime;

    /**
     *第N页，从1开始，N>=1；默认：1
     */
    @NotNull(message = "页码不能为空")
    private int pageIndex;

    /**
     *每一页数量 >=1；默认：10
     */
    @NotNull(message = "每一页数量不能为空")
    private int pageSize;



}
