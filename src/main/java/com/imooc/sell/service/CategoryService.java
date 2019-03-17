package com.imooc.sell.service;

import com.imooc.sell.dataObject.ProductCategory;

import java.util.List;

public interface CategoryService {
    //通过id找记录
    ProductCategory findOne(Integer categoryId);

    /*
    * 查询所有
    * */
    List<ProductCategory> findAll();

    /*
    * 传入list的CategoryType
    * */
    List<ProductCategory> findByCategoryTypeIn(List<Integer>categoryTypeList);

    /*
    * 增加或者更新
    * */
    ProductCategory save(ProductCategory productCategory);

}
