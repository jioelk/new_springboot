package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.dataObject.ProductCategory;
import com.imooc.sell.dataObject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productInfoServiceImpl.findUpAll();
//        for (ProductInfo ProductInfo:upAll) {
//            System.out.println(ProductInfo);
//        }
        System.out.println(upAll.size());
    }

    @Test
    public void test11(){
        List<ProductCategory> byCategoryTypeIn = categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(2,2,3));
        System.out.println(byCategoryTypeIn.size());
    }
}