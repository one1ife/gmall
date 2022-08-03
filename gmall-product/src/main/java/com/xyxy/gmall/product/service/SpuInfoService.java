package com.xyxy.gmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.gmall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 09:37:37
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

