package com.wzwl.kt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 *启动类
 * @author yangwu
 */
@RestController
@SpringBootApplication(scanBasePackages = "com.wzwl.*")
public class ServiceKetuoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceKetuoApplication.class, args);
    }


}
