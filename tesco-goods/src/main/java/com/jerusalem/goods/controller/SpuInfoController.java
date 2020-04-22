package com.jerusalem.goods.controller;

import java.util.Arrays;
import java.util.Map;

import com.jerusalem.goods.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jerusalem.goods.entity.SpuInfoEntity;
import com.jerusalem.goods.service.SpuInfoService;
import com.jerusalem.common.utils.PageUtils;
import com.jerusalem.common.utils.R;


/****
 * 控制层
 * spu信息
 * @author jerusalem
 * @email 3276586184@qq.com
 * @date 2020-04-09 14:48:19
 */
@RestController
@RequestMapping("goods/spu/info")
public class SpuInfoController {

    @Autowired
    private SpuInfoService spuInfoService;

    /***
    * 分页查询
    * @param params
    * @return
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /***
    * 查询
    * @return
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SpuInfoEntity spuInfo = spuInfoService.getById(id);

        return R.ok().put("spuInfo", spuInfo);
    }

    /***
     * 商品的新增
     * @param SpuVo
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody SpuVo SpuVo){
        spuInfoService.saveSpu(SpuVo);
        return R.ok();
    }

    /***
    * 修改
    * @return
    */
    @RequestMapping("/update")
    public R update(@RequestBody SpuInfoEntity spuInfo){
		spuInfoService.updateById(spuInfo);

        return R.ok();
    }

    /***
    * 删除
    * @return
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		spuInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}
