package com.xyxy.gmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.gmall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * εεεΊε­
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 14:31:25
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);
}

