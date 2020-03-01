package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/2/27 23:01
 * @version: 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findList(Brand brand) {
        if (brand == null) {
            return null;
        }
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtil.isNotEmpty(brand.getName())) {
            criteria.andLike("name", "%" + brand.getName() + "%" );
        }
        if (StringUtil.isNotEmpty(brand.getLetter())) {
            criteria.andEqualTo("letter", brand.getLetter());
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public List<Brand> findAll() {
        logger.info("BrandServiceImpl.findAll查询所有品牌集合");
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        logger.info("BrandServiceImpl.findById根据Id查询品牌{id}",id);
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean addBrand(Brand brand) {
        // brandMapper.insert()不会忽略对象属性为空得情况，就是空值也会写sql，影响性能
        int result = brandMapper.insertSelective(brand);
        if (result > 0) {
            logger.info("BrandServiceImpl.addBrand添加商品成功！");
            return true;
        }
        logger.info("BrandServiceImpl.addBrand添加商品击败！");
        return false;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        // brandMapper.updateByPrimaryKey()不会忽略对象属性为空得情况，可能会把一些不做更新得数据清空
        int result = brandMapper.updateByPrimaryKeySelective(brand);
        if (result > 0) {
            logger.info("BrandServiceImpl.updateByPrimaryKey更新商品成功！");
            return true;
        }
        logger.info("BrandServiceImpl.updateByPrimaryKey更新商品击败！");
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        int result = brandMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            logger.info("BrandServiceImpl.deleteByPrimaryKey删除商品成功！");
            return true;
        }
        logger.info("BrandServiceImpl.deleteByPrimaryKey删除商品击败！");
        return false;
    }
}
