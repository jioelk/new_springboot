package com.imooc.sell.Converter;

import com.imooc.sell.dataObject.OrderMaster;
import com.imooc.sell.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 22:48
 **/
public class OrderMasterToOrderDto {

    public static OrderDto convertOrderDto(OrderMaster orderMaster){
        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;

    }

    public static List<OrderDto> convertOrderList(List<OrderMaster> orderMasterList)
    {
        List<OrderDto> orderDtoList = orderMasterList.stream()
                .map(e -> convertOrderDto(e))
                .collect(Collectors.toList());
          return orderDtoList;
    }
}
