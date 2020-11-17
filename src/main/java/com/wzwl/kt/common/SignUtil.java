package com.wzwl.kt.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName SignUtil
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/6 9:45
 * @Version 1.0
 */
public class SignUtil {

    /**
     * 签名
     *
     * @param requestBody json格式参数
     * @param appSecret   密钥
     * @return
     */
    public static String paramsSign(JSONObject requestBody, String appSecret) {
        TreeMap<String, String> params=new TreeMap<>();
        //过滤掉key，appId字段，空属性及Map或List等复杂对象
        requestBody.entrySet().stream().filter(
                p -> !"key".equals(p.getKey())
                        && !"appId".equals(p.getKey())
                        && p.getValue() != null
                        && !(p.getValue() instanceof Map)
                        && !(p.getValue() instanceof Iterable))
                .forEach(p -> {
                    if (!"".equals(p.getValue())) {
                        params.put(p.getKey(), p.getValue().toString());
                    }
                });
        //拼接appSecret
        String temp=Joiner.on("&").withKeyValueSeparator("=").join(params).concat("&").concat(appSecret);
        return md5(temp).toUpperCase();
    }

    /**
     * 对文本执行 md5 摘要加密, 此算法与 mysql,JavaScript生成的md5摘要进行过一致性对比.
     *
     * @param plainText
     * @return 返回值中的字母为小写
     */
    private static String md5(String plainText) {
        if (null == plainText) {
            plainText="";
        }
        String mD5Str=null;
        try {
            // JDK 支持以下6种消息摘要算法，不区分大小写
            // md5,sha(sha-1),md2,sha-256,sha-384,sha-512
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes(StandardCharsets.UTF_8));
            byte[] b=md.digest();
            int i;
            StringBuilder builder=new StringBuilder(32);
            for (byte value : b) {
                i=value;
                if (i < 0) {
                    i+=256;
                }
                if (i < 16) {
                    builder.append("0");
                }
                builder.append(Integer.toHexString(i));
            }
            mD5Str=builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mD5Str;
    }
}


