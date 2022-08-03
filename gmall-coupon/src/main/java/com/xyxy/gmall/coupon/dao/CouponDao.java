package com.xyxy.gmall.coupon.dao;

import com.xyxy.gmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 11:29:45
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
