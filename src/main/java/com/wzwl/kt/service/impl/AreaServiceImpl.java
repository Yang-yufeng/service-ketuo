package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.ResultEntity;
import com.wzwl.kt.common.ResultEnum;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.dto.BaseDTO;
import com.wzwl.kt.service.AreaService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AreaServiceImpl
 * @Description TODO
 * @Author huff
 * @Date 2020/11/12 18:21
 * @Version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {


    @Override
    public String getAreaData(BaseDTO baseDTO) {
        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(baseDTO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_AREA_INFO,params);
        ResultEntity entity = new ResultEntity(ResultEnum.SUCCESS);
        entity.setData(response);
        return entity.toString();
    }
}
