package com.wzwl.kt.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName PostCarCardChargeInfoDTO
 * @Description TODO
 * @Author huff
 * @Date 2020/11/12 19:19
 * @Version 1.0
 */
public class PostCarCardChargeInfoDTO extends BaseDTO{

    /**
     * 卡片ID
     */
    @NotNull(message = "卡片ID不能为空")
    private Integer cardId;

    /**
     * 订单号
     */
    @NotEmpty(message = "订单号不能为空")
    private String orderNo;

    /**
     * 固定车类型
     */


}
