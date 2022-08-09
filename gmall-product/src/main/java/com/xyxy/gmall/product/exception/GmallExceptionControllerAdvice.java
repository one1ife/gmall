package com.xyxy.gmall.product.exception;

import com.xyxy.common.exception.BizCodeEnum;
import com.xyxy.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

/*
集中处理所有异常
 */
@RestControllerAdvice(basePackages = "com.xyxy.gmall.product.controller")
@Slf4j
//@ControllerAdvice(basePackages = "com.xyxy.gmall.product.controller")
public class GmallExceptionControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
      log.error("数据校验异常:{},异常类型：{}",e.getMessage(),e.getClass());
        Map<String, String> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        result.getFieldErrors().forEach((item)->{
            //FieldError //获取到错误提示
            String message = item.getDefaultMessage();
            //获取错误的属性的名字
            String field = item.getField();
            map.put(field,message);
        });
        //common提供统一的错误状态码
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(),BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        return R.error(BizCodeEnum.UNKNOW_EXCEPITON.getCode(),BizCodeEnum.UNKNOW_EXCEPITON.getMsg());
    }
}
