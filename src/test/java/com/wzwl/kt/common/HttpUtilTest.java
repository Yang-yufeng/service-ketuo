package com.wzwl.kt.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName HttpUtilTest
 * @Description TODO
 * @Author huff
 * @Date 2020/11/17 10:16
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HttpUtilTest {

    @Test
    public void doFindCarPostRequest() {

        JSONObject data = new JSONObject();
        data.put("floorId",-1);
        data.put("areaId",-1);
        System.out.println(data.toJSONString());
        String des3EncodeCBC = Des3Util.encrypt("F7A0B971B199FD2A1017CEC5", "20201117", data.toJSONString());
        String result = HttpUtil.doFindCarPostRequest("http://112.5.64.63:9099/api/find/GetFreeSpaceNum","ktapi",
                "0306A9",des3EncodeCBC);
        System.out.println(result);

    }
}