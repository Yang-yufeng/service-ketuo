package com.wzwl.kt.controller;

import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.dto.BaseDTO;
import com.wzwl.kt.service.AreaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName AreaController
 * @Description 区域相关api
 * @author huff
 * @date 2020/11/12 11:18
 * @Version 1.0
 */

@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;


    /**
     * 获取停车场区域数据、区域的停车位数量信息
     * @param baseVO
     * @return
     */
    @RequestMapping(value = "/getAreaData",method = RequestMethod.POST)
    public ResultEntity getAreaData(@RequestBody @Validated BaseDTO baseVO){


        return areaService.getAreaData(baseVO);


    }

}
