package com.xyxy.gmall.order.dao;

import com.xyxy.gmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 14:26:42
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
