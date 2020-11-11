package com.wzwl.kt;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/10 17:32
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {
        List<String> a=new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
    }
}
