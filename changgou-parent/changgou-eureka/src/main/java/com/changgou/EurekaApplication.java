package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/2/25 22:41
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer // 注意是server，开启eureka服务
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
