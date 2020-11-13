package com.wzwl.kt.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName FixedCarChargeRecordDTO
 * @Description 查询固定车充值记录
 * @Author huff
 * @Date 2020/11/12 18:17
 * @Version 1.0
 */
@Data
public class FixedCarChargeRecordDTO extends BaseDTO{


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
