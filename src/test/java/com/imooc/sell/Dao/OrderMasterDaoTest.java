package com.imooc.sell.Dao;

import com.imooc.sell.dataObject.OrderMaster;
import com.imooc.sell.enumaaa.OrderStatus;
import com.imooc.sell.enumaaa.PayStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private  OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster  orderMaster=new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12164644646");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("1646446");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        orderMaster.setOrderStatus(OrderStatus.NEW);
        orderMaster.setPayStatus(PayStatus.WAIT);
        OrderMaster save = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(save);
    }

}