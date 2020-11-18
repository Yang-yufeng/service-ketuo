package com.wzwl.kt.service;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.ResultEntity;

/**
 * @ClassName FindCarService
 * @Description TODO
 * @Author huff
 * @Date 2020/11/17 9:22
 * @Version 1.0
 */
public interface FindCarService {


    /**
     * 车位数查询（总车位数，已占有车位数，空闲车位数）
     * @return
     */
    String selectParkingSpace();

    /**
     * 根据车牌查询停车场车辆停放信息
     * @param plateNo
     * @param pageIndex
     * @param pageSize
     * @return
     */
    String getCarLocalInfo(String plateNo, Integer pageIndex, Integer pageSize);
}
