package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 10:21
 **/
public interface OrderService {

    /*创建订单*/
    OrderDto create(OrderDto orderDto);
    /*查询某个订单*/
    OrderDto findOne(String orderId);
    /*查询订单列表*/
    Page<OrderDto> findList(String openId, Pageable pageable);
    /*取消订单*/
    OrderDto cancal(OrderDto orderDto);
    /*完结订单*/
    OrderDto finish(OrderDto orderDto);
    /*支付订单*/
    OrderDto paid (OrderDto orderDto);
}
