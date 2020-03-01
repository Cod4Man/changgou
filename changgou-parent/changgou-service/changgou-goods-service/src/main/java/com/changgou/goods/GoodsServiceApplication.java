package com.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/2/27 22:55
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.changgou.goods.dao"}) // 开启Mapper扫描，注意是tk.mybatis.spring.annotation.MapperScan
public class GoodsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }
}
