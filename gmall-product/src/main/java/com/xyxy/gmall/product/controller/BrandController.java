package com.xyxy.gmall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.xyxy.common.valid.AddGroup;
import com.xyxy.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyxy.gmall.product.entity.BrandEntity;
import com.xyxy.gmall.product.service.BrandService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 10:36:51
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand/* , BindingResult result*/){
//        if(result.hasErrors()){
//            Map<String,String> map = new HashMap<>();
//            //1.获取校验的错误结果
//            result.getFieldErrors().forEach((item)->{
//
//                //FieldError //获取到错误提示
//                String message = item.getDefaultMessage();
//                //获取错误的属性的名字
//                String field = item.getField();
//                map.put(field,message);
//            });
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }else {
//            brandService.save(brand);
//        }

        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@Validated(UpdateGroup.class)@RequestBody BrandEntity brand){
//		brandService.updateById(brand);
        //不只是更新品牌表，所有冗余存储的都需要更新
        brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
