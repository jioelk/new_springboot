package com.imooc.sell.Dao;

import com.imooc.sell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    public List<ProductInfo> findByProductStatus(Integer integer);
}
