package com.wzwl.kt.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName ParkingLotRequestVO
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/12 17:12
 * @Version 1.0
 */
@Data
public class ParkingLotReqDTO {

    @NotNull(message="appId不能为空")
    private String appId;

    @NotNull(message="key不能为空")
    private String key;

    @NotNull(message="serviceCode不能为空")
    private String serviceCode;

    @NotNull(message="ts不能为空")
    private String ts;

    @NotNull(message="reqId不能为空")
    private String reqId;

    @NotNull(message="pageIndex不能为空")
    private String pageIndex;

    @NotNull(message="pageSize不能为空")
    private String pageSize;
}
