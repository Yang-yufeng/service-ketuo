package com.wzwl.kt.service;

import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.dto.BaseDTO;

/**
 * @ClassName AreaService
 * @Description TODO
 * @Author huff
 * @Date 2020/11/12 18:22
 * @Version 1.0
 */
public interface AreaService {

    /**
     * 获得区域数据、停车位数量信息
     * @param baseDTO
     * @return
     */
    ResultEntity getAreaData(BaseDTO baseDTO);

}
