package com.imooc.sell.Converter;/**
 * Created by Administrator on 2019/3/17.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dataObject.OrderDetail;
import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderFormToOrderDto
 * @Author jioe
 * @Date 2019/3/17 19:38
 **/
@Slf4j
public class OrderFormToOrderDto {
    public static OrderDto convert(OrderForm orderForm)
    {
        Gson gson=new Gson();
     OrderDto orderDto=new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        orderDto.setBuyerPhone(orderForm.getPhone());
        List<OrderDetail>orderDetailList=new ArrayList<>();
        try {
            orderDetailList= gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e)
        {
           log.error("类型转换错误,string={}",orderForm.getItems());
           throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
