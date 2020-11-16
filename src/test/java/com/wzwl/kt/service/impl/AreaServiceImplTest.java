package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.SignUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
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

import java.awt.event.WindowFocusListener;
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
        //测试
        baseDTO.setAppId("10031");
        baseDTO.setParkId(592011251);
        //正式
        //baseDTO.setAppId("10156");
        //baseDTO.setParkId(115);
        baseDTO.setReqId(UUID.randomUUID().toString().replace("-", ""));
        baseDTO.setServiceCode("getParkingPlaceArea");
        baseDTO.setTs(System.currentTimeMillis() + "");
        //测试key
        String key= SignUtil.paramsSign((JSONObject) JSONObject.toJSON(baseDTO), "9d682649d9f64faeb5e4477a8e27858e");
        //String key= SignUtil.paramsSign((JSONObject) JSONObject.toJSON(baseDTO), "cba9dccc39e247c6afe53157b96422b2");
        baseDTO.setKey(key);
        //测试地址
        String url = "https://tsktapps.keytop.cn/unite-api/api/wec/GetParkingPlaceArea";
        log.info("请求地址为:{}",url);
        log.info("请求参数为:{}",JSONObject.toJSONString(baseDTO));
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(baseDTO));
        String response =  HttpUtil.doPostRequestJson(url,params);
        //String response = areaService.getAreaData(baseDTO);
        log.info("响应结果:"+response);
        JSONObject result = JSONObject.parseObject(response);
        JSONObject data = result.getJSONObject("data");
        log.info("返回结果为:{}",data.toJSONString());
        /*log.info("停车场区域数为:{}",data.getString("parkArea"));
        log.info("停车场总停车位为:{}",data.getIntValue("totalPlaceCount"));
        JSONArray array = data.getJSONArray("areaInfo");
        log.info("停车场区域信息为:{}",array.toJSONString());*/

    }
}