package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/2/27 23:02
 * @version: 1.0
 */
public interface BrandService {

    /**
     * 按条件查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /**
     * 查询所有商品集合
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据id查找商品品牌
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     * @param brand
     * @return 是否添加成功
     */
    boolean addBrand(Brand brand);

    /**
     * 更新品牌信息
     * @param brand
     * @return
     */
    boolean updateBrand(Brand brand);

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

}
