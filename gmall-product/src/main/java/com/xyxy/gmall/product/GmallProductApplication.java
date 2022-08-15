package com.xyxy.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
2.逻辑删除
    配置全局的逻辑删除规则 （省略）
    配置逻辑删除的组件 （省略）
    给Bean加上逻辑删除注解@TableLogic

3.JSR303
    给Bean加上校验注解:javax.validation 并可定义自己的message提示
    开启校验功能@valid
        效果：校验错误后会有默认的响应
    给校验的bean后紧跟一个bindingResult,就可以获取到校验的结果
    分组校验:（）多场景的复杂校验
        @Null(message = "修改必须指定品牌id",groups = {UpdateGroup.class})
        给校验注解标注什么情况进行校验
        @Validated(AddGroup.class)
        默认没有指定分组校验注解@NotNUll,在分组校验情况下不生效。不分组@Valid生效

4.统一的异常处理
@ControllerAdvice

5.自定义校验
    编写一个自定义的校验注解
    编写一个自定义的校验器
    关联自定义的校验器
    @Documented
    @Constraint(
            validatedBy = {ListValueConstraintValidator.class // 可以指定多个不同的校验器，适配不同类型的校验}
    )
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ListValue {
*/
@EnableFeignClients(basePackages = "com.xyxy.gmall.product.feign")
@MapperScan("com.xyxy.gmall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallProductApplication.class, args);
    }

}
