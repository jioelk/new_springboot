package com.imooc.sell.service.serviceImpl;/**
 * Created by MAIBENBEN on 2019/3/19.
 */

import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/19 18:49
 * @Description:
 */
@Service
@Transactional
@Slf4j
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private OrderService orderService;
    @Override
    public OrderDto findOrderOne(String openid, String orderId) {

        return getOwner(openid, orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto owner = getOwner(openid, orderId);
        if(owner==null) {
            log.error("查不到该订单,orderDto={}", owner);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancal(owner);
    }

    public OrderDto getOwner(String openid, String orderId){
        OrderDto one = orderService.findOne(orderId);
        if(one==null)
        {
            return null;
        }
        if(!one.getBuyerOpenid().equalsIgnoreCase(openid))
        {
            log.error("此用户不是订单用户,openid={},orderDto={}",openid,one);
            throw new SellException(ResultEnum.OWNER_UNCORRECT);
        }
       return one;
    }
}
