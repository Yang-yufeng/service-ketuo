package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.Des3Util;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.common.ResultEnum;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.service.FindCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FindCarService
 * @Description TODO
 * @Author huff
 * @Date 2020/11/17 9:26
 * @Version 1.0
 */
@Service
@Slf4j
public class FindCarServiceImpl implements FindCarService {


    @Override
    public JSONObject selectParkingSpace() {

        JSONObject data = new JSONObject();
        data.put("floorId",0);
        data.put("areaId",0);

        //todo 应从上层获得  配置信息？
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String secretIV = format.format(new Date());
        String des3EncodeCBC = Des3Util.encrypt("F7A0B971B199FD2A1017CEC5", secretIV, data.toJSONString());
        String response = HttpUtil.doFindCarPostRequest(RequestUrlConstants.GET_PARKING_SPACE,"ktapi","0306A9",des3EncodeCBC);

        JSONObject result = JSONObject.parseObject(response);

        return result;
    }

    @Override
    public JSONObject getCarLocalInfo(String plateNo, Integer pageIndex, Integer pageSize) {
        JSONObject data = new JSONObject();
        data.put("plateNo",plateNo);
        data.put("pageIndex",pageIndex);
        data.put("pageSize",pageSize);

        //todo 应从上层获得  配置信息？

        String response = HttpUtil.doFindCarPostRequest(RequestUrlConstants.GET_CAR_LOCATION,"ktapi","0306A9","F7A0B971B199FD2A1017CEC5", data);

        JSONObject result = JSONObject.parseObject(response);

        return result;
    }


}
