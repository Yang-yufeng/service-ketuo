package com.wzwl.kt.service;

import com.wzwl.kt.vo.BaseDTO;

/**
 * @author huff
 * @date 2020/11/12 13:40
 */
public interface AreaService {

    /**
     * 获得区域数据、停车位数量信息
     * @param baseVO
     * @return
     */
    String getAreaData(BaseDTO baseVO);
}
