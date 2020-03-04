package com.changgou.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/3/4 20:12
 * @version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 移除数据库相关配置的自动加载
@EnableEurekaClient
public class FilesApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilesApplication.class, args);
    }
}
