package com.wzwl.kt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.ResponseUtil;
import com.wzwl.kt.constants.RequestUrlConstants;
import com.wzwl.kt.service.AreaService;
import com.wzwl.kt.vo.BaseVO;
import org.springframework.stereotype.Service;

/**
 * @author huff
 * @date 2020/11/12 13:41
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Override
    public String getAreaData(BaseVO baseVO) {

        //调用api接口获取充值规则
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(baseVO));
        String response =  HttpUtil.doPostRequestJson(RequestUrlConstants.GET_AREA_INFO,params);

        return ResponseUtil.getResponse(response);

    }

}
