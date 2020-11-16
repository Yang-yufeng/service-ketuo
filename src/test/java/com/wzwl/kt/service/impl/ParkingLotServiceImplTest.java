package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.SignUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.DeviceReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @ClassName ParkingLotServiceImplTest
 * @Description TODO
 * @Author huff
 * @Date 2020/11/16 16:18
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ParkingLotServiceImplTest {

    @Test
    public void listDevicesTest() {

        DeviceReqDTO deviceReqDTO = new DeviceReqDTO();
        deviceReqDTO.setAppId("10031");
        deviceReqDTO.setParkId(592011251);
        deviceReqDTO.setReqId(UUID.randomUUID().toString().replace("-", ""));
        deviceReqDTO.setServiceCode("getDeviceList");
        deviceReqDTO.setTs(System.currentTimeMillis() + "");
        deviceReqDTO.setDeviceType(0);
        String key= SignUtil.paramsSign((JSONObject) JSONObject.toJSON(deviceReqDTO), "9d682649d9f64faeb5e4477a8e27858e");
        deviceReqDTO.setKey(key);
        String url = "https://tsktapps.keytop.cn/unite-api/api/wec/GetDeviceList";
        log.info("请求地址为:{}",url);
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(deviceReqDTO));
        String response = HttpUtil.doPostRequestJson(url, params);
        log.info("响应结果:"+response);
        JSONObject result = JSONObject.parseObject(response);
        JSONObject data = result.getJSONObject("data");
        log.info("返回结果为:{}",data.toJSONString());
    }
}