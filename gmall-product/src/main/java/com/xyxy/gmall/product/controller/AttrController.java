package com.xyxy.gmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xyxy.gmall.product.entity.ProductAttrValueEntity;
import com.xyxy.gmall.product.service.ProductAttrValueService;
import com.xyxy.gmall.product.vo.AttrGroupRelationVo;
import com.xyxy.gmall.product.vo.AttrRespVo;
import com.xyxy.gmall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xyxy.gmall.product.entity.AttrEntity;
import com.xyxy.gmall.product.service.AttrService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.common.utils.R;



/**
 * 商品属性
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 10:36:51
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    ProductAttrValueService productAttrValueService;

    //product/attr/base/list/{catelogId}
    @GetMapping("/base/listforspu/{spuId}")
    public R baseAttrListforspu(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> entityList =  productAttrValueService.baseAttrListforspu(spuId);
        return R.ok().put("data",entityList);
    }



    ///info/1 : 查询修改回显级联菜单



    // /base/list/{catelogId}
    // /sale/list/{catelogId}
    @GetMapping("/{attrType}/list/{catelogId}")
    public  R baseAttrList(@RequestParam Map<String,Object> params,
                           @PathVariable("catelogId") Long catelogId,
                           @PathVariable("attrType") String type){
        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    //product/attr/update/{spuId}
    @PostMapping("/update/{spuId}")
    public R updateSpuAttr(@PathVariable("spuId") Long spuId,
                           @RequestBody List<ProductAttrValueEntity> entities){

        productAttrValueService.updateSpuAttr(spuId,entities);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
