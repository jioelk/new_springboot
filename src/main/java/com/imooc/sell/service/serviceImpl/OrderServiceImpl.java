package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.Converter.OrderMasterToOrderDto;
import com.imooc.sell.Dao.OrderDetailDao;
import com.imooc.sell.Dao.OrderMasterDao;
import com.imooc.sell.dataObject.OrderDetail;
import com.imooc.sell.dataObject.OrderMaster;
import com.imooc.sell.dataObject.ProductInfo;
import com.imooc.sell.dto.CartDto;
import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 10:37
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public OrderDto create(OrderDto orderDto) {
        //1.查询商品
        String uniqueKey = RandomUtils.getUniqueKey();
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        BigDecimal total=new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail:orderDetailList)
        {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo==null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            total = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()));
            total.add(total);
            //3.插入订单详情数据库
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetail.setOrderId(uniqueKey);
            orderDetail.setDetailId(RandomUtils.getUniqueKey());
            orderDetailDao.save(orderDetail);
        }
        //插入订单主表
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderId(uniqueKey);
        orderMaster.setOrderAmount(total);
        orderMasterDao.save(orderMaster);
        //4.扣库存
        final List<CartDto> cartDtoList = orderDetailList.stream()
                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDtoList);
        return null;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderDto orderDto=new OrderDto();
        OrderMaster orderMaster = orderMasterDao.findOne(orderId);
        if(orderMaster==null)
        {
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetails = orderDetailDao.findByOrderId(orderId);
        BeanUtils.copyProperties(orderMaster,orderDto);
        orderDto.setOrderDetailList(orderDetails);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String openId, Pageable pageable)
    {
        Page<OrderMaster> orderMasters = orderMasterDao.findByBuyerOpenid(openId, pageable);
        List<OrderDto> orderDtos = OrderMasterToOrderDto.convertOrderList(orderMasters.getContent());
        Page<OrderDto>orderDtoPage=new PageImpl<OrderDto>(orderDtos,pageable,orderMasters.getTotalElements());
        return orderDtoPage;
    }

    @Override
    public OrderDto cancal(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
}
