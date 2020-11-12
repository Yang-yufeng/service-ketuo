package com.wzwl.kt.vo;

import com.wzwl.kt.enums.CarTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author huff
 * @date 2020/11/12 14:55
 */
@Data
public class RechargeRuleInfoVo extends BaseVO{

    /**
     * 固定车类型
     */
    private int carType;

}
