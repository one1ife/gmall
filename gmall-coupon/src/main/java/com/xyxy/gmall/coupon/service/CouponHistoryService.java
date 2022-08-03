package com.xyxy.gmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.gmall.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 11:29:45
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

