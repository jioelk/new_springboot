package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.dataObject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    private Logger logger= LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() {
        ProductCategory one = categoryServiceImpl.findOne(4);
       // System.out.println(one);
       logger.info(one.toString());

    }

    @Test
    public void findAll() {

        List<ProductCategory> all = categoryServiceImpl.findAll();
        System.out.println(all);

    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> byCategoryTypeIn = categoryServiceImpl.findByCategoryTypeIn(list);
        System.out.println(byCategoryTypeIn.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("海洋生物");
        productCategory.setCategoryType(6);
        categoryServiceImpl.save(productCategory);
    }
}