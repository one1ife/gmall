package com.xyxy.gmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.gmall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 11:29:45
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

