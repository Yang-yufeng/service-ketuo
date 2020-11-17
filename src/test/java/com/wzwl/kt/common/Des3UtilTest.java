package com.wzwl.kt.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName Des3UtilTest
 * @Description TODO
 * @Author huff
 * @Date 2020/11/17 9:48
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Des3UtilTest {

    @Test
    public void encrypt() {

        JSONObject data = new JSONObject();
        data.put("floorId",0);
        data.put("areaId",0);
        //data.put("plateNo","A12345");
        log.info("需要加密的字符串内容为：【{}】",data);

        String des3EncodeCBC = Des3Util.encrypt("F7A0B971B199FD2A1017CEC5", "20201117", data.toJSONString());
        log.info("经加密后的字符串内容为：【{}】",des3EncodeCBC);
        assertEquals(des3EncodeCBC,"DkTwRsUUza33A8/TvrocXI3r+Az1T7bt");


    }
}