package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/2/27 23:03
 * @version: 1.0
 */
@RestController
@RequestMapping("/brand")
@CrossOrigin // 跨域: ip/port/协议发生了改变就算跨域
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll() {
        return new Result<>(true, StatusCode.OK, "查询全部成功！", brandService.findAll());
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        return new Result<>(true, StatusCode.OK, "按条件查询成功！", brandService.findList(brand));
    }

    @RequestMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        return new Result<>(true, StatusCode.OK, "通过id查询成功！", brandService.findById(id));
    }

    @PostMapping
    public Result addBrand(@RequestBody Brand brand) {
        boolean res = brandService.addBrand(brand);
        if (res) {
            return new Result(true, StatusCode.OK,"添加商品成功！");
        }
        return new Result(false, StatusCode.ERROR, "添加商品失败！");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable(value = "id") Integer idd, @RequestBody Brand brand) {
        brand.setId(idd);
        boolean res = brandService.updateBrand(brand);
        if (res) {
            return new Result(true, StatusCode.OK,"更新商品成功！");
        }
        return new Result(false, StatusCode.ERROR, "更新商品失败！");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean res = brandService.deleteById(id);
        if (res) {
            return new Result(true, StatusCode.OK,"删除商品成功！");
        }
        return new Result(false, StatusCode.ERROR, "删除商品失败！");
    }
}
