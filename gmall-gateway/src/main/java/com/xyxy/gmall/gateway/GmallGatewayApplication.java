package com.xyxy.gmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
开启服务注册发现
(配置nacos注册中心地址)
 */

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GmallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallGatewayApplication.class, args);
    }

}
