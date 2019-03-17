package com.imooc.sell.Controller;/**
 * Created by Administrator on 2019/3/17.
 */

import com.imooc.sell.Converter.OrderFormToOrderDto;
import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.dto.ResultDto;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BuyerOrderController
 * @Author jioe
 * @Date 2019/3/17 19:28
 **/

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    //@valid是要放对象
    public ResultDto<Map<String,String>>create(@Valid OrderForm orderForm,BindingResult bindingResult)
    {
      if(bindingResult.hasErrors())
      {
          log.error("创建订单参数不正确,orderForm={}",orderForm);
          throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
      }

        OrderDto orderDto = OrderFormToOrderDto.convert(orderForm);
      if(CollectionUtils.isEmpty(orderDto.getOrderDetailList()))
      {
         throw new SellException(ResultEnum.CART_EMPTY);
      }
        OrderDto result = orderService.create(orderDto);
      Map<String,String>map=new HashMap<>();
      map.put("orderId",result.getOrderId());
      return null;
    }
}
