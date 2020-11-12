package com.wzwl.kt.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @author huff
 * @date 2020/11/12 14:22
 */
public class ResponseUtil {


    public static String getResponse(String response){

        JSONObject responseJson = JSONObject.parseObject(response);

        boolean reportSuccess=responseJson.getBoolean("success");
        if (!reportSuccess) {
            ResultEntity result=new ResultEntity(ResultEnum.DATA_REPORT_ERROR);
            return result.toString();
        }
        ResultEntity result=new ResultEntity(ResultEnum.SUCCESS);
        return result.toString();
    }


}
