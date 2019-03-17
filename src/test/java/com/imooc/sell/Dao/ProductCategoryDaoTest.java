package com.imooc.sell.Dao;

import com.imooc.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void  findOne(){
        ProductCategory one = productCategoryDao.findOne(3);
        System.out.println(one.toString());

    }

    @Test
    public void  saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("植物");
        productCategory.setCategoryType(1);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void deleteTest(){
        productCategoryDao.deleteAllInBatch();
    }

    public void saveTest2(){
        ProductCategory productCategory=productCategoryDao.findOne(2);
        //先查出来再set数据进去updatetime不会改，只有全部数据set进去用save才会更新
        productCategory.setCategoryType(10);
    }

    @Test
    public void testList(){
        List<Integer> list= Arrays.asList(1,2,3);
        List<ProductCategory> byCategoryTypeIn = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
        System.out.println(byCategoryTypeIn.size());
    }
}