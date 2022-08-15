package com.xyxy.gmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xyxy.gmall.product.entity.AttrEntity;
import com.xyxy.gmall.product.service.AttrAttrgroupRelationService;
import com.xyxy.gmall.product.service.AttrService;
import com.xyxy.gmall.product.service.CategoryService;
import com.xyxy.gmall.product.vo.AttrGroupRelationVo;
import com.xyxy.gmall.product.vo.AttrGroupWithAttrsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xyxy.gmall.product.entity.AttrGroupEntity;
import com.xyxy.gmall.product.service.AttrGroupService;
import com.xyxy.common.utils.PageUtils;
import com.xyxy.common.utils.R;



/**
 * 属性分组
 *
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 10:36:51
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    AttrAttrgroupRelationService relationService;

    //product/attrgroup/attr/relation
    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> vos){
        relationService.saveBatch(vos);
        return R.ok();

    }

    //    product/attrgroup/1/noattr/relation?t=1660226442086&page=1&limit=10&key=
    @GetMapping("/{attrgroup}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroup") Long attrgroupId,
                            @RequestParam Map<String,Object> params){
        PageUtils pageUtils = attrService.getNoRelationAttr(attrgroupId,params);
        return R.ok().put("page",pageUtils);
    }

    // /{attrgroup}/attr/relation
    @GetMapping("/{attrgroup}/attr/relation")
    public R attrRelation(@PathVariable("attrgroup") Long attrgroupId){
        List<AttrEntity> entityList = attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data",entityList);
    }

    // http://localhost:88/api/product/attrgroup/225/withattr?t=1660354253846
    @GetMapping("/{catelogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable("catelogId") Long catelogId){
        //1.查出当前分类下的所有属性分组

        //2.查出每个属性分组的所有属性
        List<AttrGroupWithAttrsVO> vos =  attrGroupService.getAtrGroupWithAttrsByCatelogId(catelogId);
        return R.ok().put("data",vos);

    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId){
//        PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params, catelogId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCatelogPath(catelogId);
        attrGroup.setCatelogPath(path);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    // /attrgroup/attr/relation/delete
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] vos){
        attrService.deleteRelation(vos);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
