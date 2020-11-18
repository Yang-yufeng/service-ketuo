package com.wzwl.kt.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.service.FindCarService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName FindCarController
 * @Description 找车系统控制器
 * @Author huff
 * @Date 2020/11/17 9:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/car")
public class FindCarController {


    @Resource
    FindCarService findCarService;

    /**
     * 车位数查询（总车位数，已占有车位数，空闲车位数）
     * @return
     */
    @RequestMapping("/selectParkingSpace")
    public String selectParkingSpace(){

        return findCarService.selectParkingSpace();

    }


    /**
     * 根据车牌查询停车场车辆停放信息
     * @return
     */
    @RequestMapping("/getCarLocalInfo")
    public String searchCarByCarLicense(@RequestBody JSONObject params){
        String plateNo = params.getString("plateNo");
        Integer pageIndex = params.getInteger("pageIndex");
        Integer pageSize = params.getInteger("pageSize");
        return findCarService.getCarLocalInfo(plateNo,pageIndex,pageSize);

    }


}
