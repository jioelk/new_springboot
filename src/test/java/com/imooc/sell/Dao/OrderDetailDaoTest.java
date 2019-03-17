package com.imooc.sell.Dao;

import com.imooc.sell.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
   public void test(){
        OrderDetail orderdDetail =new OrderDetail();
        orderdDetail.setDetailId("123456789");
        orderdDetail.setOrderId("11111111");
        orderdDetail.setProductIcon("http://xxxx.jpg");
        orderdDetail.setProductId("11111112");
        orderdDetail.setProductName("皮蛋粥");
        orderdDetail.setProductPrice(new BigDecimal(2.3));
        orderdDetail.setProductQuantity(2);
        OrderDetail save = orderDetailDao.save(orderdDetail);
        Assert.assertNotNull(save);
    }

}