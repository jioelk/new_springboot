package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDto;

/**
 * Created by Administrator on 2019/3/25.
 */
public interface PayService {

    void create(OrderDto orderDto);
}
