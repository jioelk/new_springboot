package com.imooc.sell.Controller;/**
 * Created by Administrator on 2019/3/24.
 */

import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName PayController
 * @Author jioe
 * @Date 2019/3/24 19:31
 **/
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @RequestMapping(value ="/create",method = RequestMethod.GET)
    public void aa(@RequestParam("orderId")String orderId,
                   @RequestParam("returnUrl")String returnUrl)
    {
      //查询订单
        OrderDto orderDto = orderService.findOne(orderId);
        if(orderDto==null)
        {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        payService.create(orderDto);
    }

}
