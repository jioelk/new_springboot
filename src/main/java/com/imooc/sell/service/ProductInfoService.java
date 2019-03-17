package com.imooc.sell.service;

import com.imooc.sell.dataObject.ProductInfo;
import com.imooc.sell.dto.CartDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductInfoService {

    public ProductInfo findOne(String productId);

    //带分页
    public Page<ProductInfo> findAll(Pageable pageable);


    public List<ProductInfo> findUpAll();

    public ProductInfo save(ProductInfo productInfo);

    //加库存
    public void increaseStock(List<CartDto>cartList);
    //减库存
    public void decreaseStock(List<CartDto>cartList);
}
