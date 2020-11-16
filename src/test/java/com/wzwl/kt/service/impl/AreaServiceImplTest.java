package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.SignUtil;
import com.wzwl.kt.dto.BaseDTO;
import com.wzwl.kt.dto.DeviceReqDTO;
import com.wzwl.kt.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @ClassName AreaServiceImplTest
 * @Description TODO
 * @Author huff
 * @Date 2020/11/16 14:20
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AreaServiceImplTest {

    @Resource
    AreaService areaService;

    @Test
    public void getAreaDataTest() {
        BaseDTO baseDTO = new BaseDTO() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        baseDTO.setAppId("10156");
        baseDTO.setParkId(115);
        baseDTO.setReqId(UUID.randomUUID().toString().replace("-", ""));
        baseDTO.setServiceCode("getParkingPlaceArea");
        baseDTO.setTs(System.currentTimeMillis() + "");
        String key= SignUtil.paramsSign((JSONObject) JSONObject.toJSON(baseDTO), "cba9dccc39e247c6afe53157b96422b2");
        baseDTO.setKey(key);
        log.info("请求参数为:{}",baseDTO);
        String response = areaService.getAreaData(baseDTO);
        log.info(response);
        JSONObject result = JSONObject.parseObject(response);
        log.info("停车场区域数为:{}",result.get("parkArea"));
        log.info("停车场总停车位为:{}",result.get("totalPlaceCount"));
        log.info("停车场区域信息为:{}",result.get("areaInfo"));

    }
}