package com.wzwl.kt.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName DeviceRequestVO
 * @Description 设备信息请求封装参数
 * @Author yangwu
 * @Date 2020/11/12 15:58
 * @Version 1.0
 */
@Data
public class DeviceReqDTO extends BaseDTO {

    @NotNull(message="deviceType不能为空")
    private Integer deviceType;
}
