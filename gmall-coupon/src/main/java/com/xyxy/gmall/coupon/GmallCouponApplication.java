package com.xyxy.gmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/*
一、如何使用nacos作为配置中心统一管理配置
1.引入依赖
    <dependency>
         <groupId>com.alibaba.cloud</groupId>
         <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    </dependency>
2.创建一个bootstrap.properties
spring.application.name=gmall-coupon
spring.cloud.nacos.config.server-addr=127.0.0.1:8848

3.需要给配置中心默认添加一个叫数据集（Data id） gmall-coupon.properties : 默认规则：应用名.properties
4.给应用名.properties添加任何配置
5.动态获取配置(引入bootstrap依赖)
    @RefreshScope:动态获取并刷新配置
    @Value("{配置的项名}")：获取到配置
    如果配置中心和当前应用的配置文件都配置了相同的项，优先使用配置中心的配置

二、细节
    1.命名空间：配置隔离
     默认：public(保留空间)；默认新增的所有配置都在public空间
      a 开发、测试、生产:利用命名空间来做环境隔离
        注意：在bootstrap.properties;配置上，需要使用哪个命名空间下的配置
        spring.cloud.nacos.config.namespace=7229e9a6-363f-49a2-85ba-5c14ea8bf6c8
      b 每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间
    2.配置集：所有的配置集合
    3.配置集id：类似文件名
        Data ID:类似文件名
    4.配置分组：
        默认所有的配置集都属于DEFAULT_GROUP;
每个微服务创建自己的命名空间，使用配置分组区分环境，dec\test\prop

三.同时加载多个配置集
    1.微服务任何配置信息，任何配置文件都可以放在配置中心中
    2.只需要在bootstrap.rpoperties说明加载配置中心中哪些配置文件即可
    3.@Value,@ConfigurationProperties...
    以前Spring任何方法从配置文件中获取值，都能使用
    配置中心有的优先使用配置中心的

 */
@EnableDiscoveryClient//开启服务注册与发现功能
@SpringBootApplication
public class GmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallCouponApplication.class, args);
    }

}
