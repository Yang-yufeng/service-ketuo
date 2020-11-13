package com.wzwl.kt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName PayCarCardFeeDTO
 * @Description 固定车充值上报
 * @Author huff
 * @Date 2020/11/12 18:18
 * @Version 1.0
 */
@Data
public class PayCarCardFeeDTO extends BaseDTO{

    /**
     * 当前操作用户ID
     */
    @NotBlank(message="userId不能为空")
    private String userId;

    /**
     * 操作用户名称
     */
    @NotBlank(message="userName不能为空")
    private String userName;

    /**
     * 卡片ID
     */
    @NotNull(message="卡片ID不能为空")
    private int cardId;

    /**
     * 订单号
     */
    @NotBlank(message="订单号不能为空")
    private String orderNo;

    /**
     * 固定车类型
     */
    @NotNull(message="固定车类型不能为空")
    private int carType;

    /**
     * 支付渠道
     */
    @NotNull(message="支付渠道不能为空")
    private int payChannel;

    /**
     * 充值方式,(0 钱(单位:分),1 月,2 天,3 小时,4次)
     */
    @NotNull(message="充值方式不能为空")
    private int chargeMethod;

    /**
     * 充值车的充值月数或天数或次数
     */
    @NotNull(message="充值车的充值月数或天数或次数不能为空")
    private int chargeNumber;

    /**
     * 支付金额（单位：分）
     */
    @NotNull(message="支付金额不能为空")
    private int amount;

    /**
     * 免费赠送的月数或天数或次数
     */
    @NotNull(message="免费赠送的月数或天数或次数不能为空")
    private int freeNumber;

    /**
     * 充值开始时间
     */
    @NotBlank(message="充值开始时间不能为空")
    private String validFrom;

    /**
     * 充值结束时间
     */
    @NotBlank(message="充值结束时间不能为空")
    private String validTo;

    /**
     * 创建时间
     */
    @NotBlank(message="创建时间不能为空")
    private String createTime;

    /**
     * 备注
     */
    @NotBlank(message="备注不能为空")
    private String remark;

}
