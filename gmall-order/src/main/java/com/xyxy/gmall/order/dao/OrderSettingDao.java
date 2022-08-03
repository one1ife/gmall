package com.xyxy.gmall.order.dao;

import com.xyxy.gmall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 14:26:42
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
