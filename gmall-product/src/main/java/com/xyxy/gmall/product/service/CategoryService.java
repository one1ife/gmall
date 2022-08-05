package com.xyxy.gmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.gmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 09:37:37
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

