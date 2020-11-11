package com.wzwl.kt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceKetuoApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceKetuoApplication.class, args);
    }


}
