package com.xyxy.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1.整合MyBatis-Plus
   a) 导入依赖
   <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.3.1</version>
    </dependency>
    b) 配置
        1.配置数据源
          导入数据库驱动
          application.yml配置数据源相关信息
        2.配置MyBatis-Plus：
          使用@MapperScan
          告诉MyBatis-Plus，映射文件位置



*/
@MapperScan("com.xyxy.gmall.product.dao")
@SpringBootApplication
public class GmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallProductApplication.class, args);
    }

}
