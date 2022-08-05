package com.xyxy.gmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
一、想要远程调用别的服务
1.引入open-feign
2.编写一个接口，告诉SpringCloud这个接口需要调用远程服务
    a 声明接口的每一个方法都是调用哪个远程服务的哪个请求
3.开启远程调用功能
 */

@EnableFeignClients("com.xyxy.gmall.member.feign")
@SpringBootApplication
public class GmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallMemberApplication.class, args);
    }

}
