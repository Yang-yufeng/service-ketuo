package com.wzwl.kt.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName PassageRequestVo
 * @Description 通道信息请求封装参数
 * @Author yangwu
 * @Date 2020/11/12 15:20
 * @Version 1.0
 */
@Data
public class PassageRequestVO extends BaseDTO {


    @NotNull(message="page不能为空")
    private Integer pageIndex;

    @NotNull(message="pageSize不能为空")
    private Integer pageSize;


}
