package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/3/25.
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class PayServiceImplTest {
    private static final String ORDER_NAME="微信点餐系统";
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDto one = orderService.findOne("1552985999549485593");
        payService.create(one);
    }
}

