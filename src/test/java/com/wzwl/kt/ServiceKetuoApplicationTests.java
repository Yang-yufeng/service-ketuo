package com.wzwl.kt;

import com.alibaba.fastjson.JSONObject;
import com.wzwl.kt.common.HttpUtil;
import com.wzwl.kt.common.SignUtil;
import com.wzwl.kt.dto.PassageReqDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceKetuoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRpc() throws ServletException, IOException {
        JSONObject imageJson=new JSONObject();
        imageJson.put("appId", "10156");
        imageJson.put("parkId", 115);
        imageJson.put("serviceCode", "getParkingImg");
        imageJson.put("ts", System.currentTimeMillis() + "");
        imageJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
        imageJson.put("imgName", "20201109184111538_192.168.8.189_033292.jpg");
        imageJson.put("type", 1);
        String imageKey=SignUtil.paramsSign(imageJson, "cba9dccc39e247c6afe53157b96422b2");
        System.out.println(imageKey);
        imageJson.put("key", imageKey);
        System.out.println(imageJson);
        String imageResponse=HttpUtil.doPostRequestJson("http://kp-open.keytop.cn/unite-api/api/wec/GetParkingImg", imageJson);
        //String imageResponse=HttpUtil.doPost(null,null,imageJson,"http://kp-open.keytop.cn/unite-api/api/wec/GetParkingImg");
        JSONObject imageResponseJson=JSONObject.parseObject(imageResponse);
        System.out.println("图片请求结果====================" + imageResponse);
        JSONObject imgUrlJson=imageResponseJson.getJSONObject("data");
        System.out.println(imgUrlJson.getString("imgUrl"));
    }

    @Test
    public void testGetFreeLots() throws ServletException, IOException {
        JSONObject paramJson=new JSONObject();
        paramJson.put("appId", "10156");
        paramJson.put("parkId", 115);
        paramJson.put("serviceCode", "getFreeSpaceNum");
        paramJson.put("ts", System.currentTimeMillis() + "");
        paramJson.put("reqId", UUID.randomUUID().toString().replace("-", ""));
        paramJson.put("isFindCarSys", 0);
        String key=SignUtil.paramsSign(paramJson, "cba9dccc39e247c6afe53157b96422b2");
        paramJson.put("key", key);
        System.out.println("请求参数======================" + paramJson);
        String freeLotsResponse=HttpUtil.doPostRequestJson("http://kp-open.keytop.cn/unite-api/api/wec/GetFreeSpaceNum", paramJson);
        System.out.println("车位数请求结果====================" + freeLotsResponse);
        JSONObject freeLotsResponseJson=JSONObject.parseObject(freeLotsResponse);
        JSONObject dataJson=freeLotsResponseJson.getJSONObject("data");
        System.out.println("总车位数=====================" + dataJson.getInteger("totalNum"));
        System.out.println("空闲车位数=====================" + dataJson.getInteger("freeSpaceNum"));
    }

    @Test
    public void testGetPassages(){
        PassageReqDTO passageReqDTO= new PassageReqDTO();
        passageReqDTO.setAppId("10156");
        passageReqDTO.setParkId(115);
        passageReqDTO.setServiceCode("getParkingNode");
        passageReqDTO.setReqId(UUID.randomUUID().toString().replace("-", ""));
        passageReqDTO.setTs(System.currentTimeMillis() + "");
        passageReqDTO.setPageIndex(1);
        passageReqDTO.setPageSize(100);
        String key=SignUtil.paramsSign((JSONObject) JSONObject.toJSON(passageReqDTO), "cba9dccc39e247c6afe53157b96422b2");
        passageReqDTO.setKey(key);
        String passagesResponse=HttpUtil.doPostRequestJson("http://kp-open.keytop.cn/unite-api/api/wec/GetParkingNode", (JSONObject) JSONObject.toJSON(passageReqDTO));
        System.out.println("通道信息数请求结果====================" + passagesResponse);
        System.out.println((JSONObject) JSONObject.toJSON(passageReqDTO));
        JSONObject freeLotsResponseJson=JSONObject.parseObject(passagesResponse);
        JSONObject dataJson=freeLotsResponseJson.getJSONObject("data");
        //System.out.println("总车位数=====================" + dataJson.getInteger("totalNum"));
        //System.out.println("空闲车位数=====================" + dataJson.getInteger("freeSpaceNum"));
    }
    @Test
    public void testGetPassages1(){
        PassageReqDTO passageReqDTO= new PassageReqDTO();
        passageReqDTO.setAppId("10031");
        passageReqDTO.setParkId(592011251);
        passageReqDTO.setServiceCode("getParkingNode");
        passageReqDTO.setReqId(UUID.randomUUID().toString().replace("-", ""));
        passageReqDTO.setTs(System.currentTimeMillis() + "");
        passageReqDTO.setPageIndex(1);
        passageReqDTO.setPageSize(100);
        String key=SignUtil.paramsSign((JSONObject) JSONObject.toJSON(passageReqDTO), "9d682649d9f64faeb5e4477a8e27858e");
        passageReqDTO.setKey(key);
        String passagesResponse=HttpUtil.doPostRequestJson("https://tsktapps.keytop.cn/unite-api/api/wec/GetParkingNode", (JSONObject) JSONObject.toJSON(passageReqDTO));
        System.out.println("通道信息数请求结果====================" + passagesResponse);
        System.out.println((JSONObject) JSONObject.toJSON(passageReqDTO));
        JSONObject freeLotsResponseJson=JSONObject.parseObject(passagesResponse);
        JSONObject dataJson=freeLotsResponseJson.getJSONObject("data");
        //System.out.println("总车位数=====================" + dataJson.getInteger("totalNum"));
        //System.out.println("空闲车位数=====================" + dataJson.getInteger("freeSpaceNum"));
    }




}
