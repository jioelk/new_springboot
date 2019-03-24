package com.imooc.sell.service;/**
 * Created by MAIBENBEN on 2019/3/19.
 */

import com.imooc.sell.dto.OrderDto;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/19 18:46
 * @Description:
 */
public interface BuyerService {
    public OrderDto findOrderOne(String openid,String orderId);

    public OrderDto cancelOrder(String openid,String orderId);
}
