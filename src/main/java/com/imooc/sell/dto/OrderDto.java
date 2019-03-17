package com.imooc.sell.dto;

import com.imooc.sell.dataObject.OrderDetail;
import com.imooc.sell.enumaaa.OrderStatus;
import com.imooc.sell.enumaaa.PayStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 10:13
 **/
@Data
public class OrderDto {

    @ApiModelProperty("订单id")
    private  String  orderId;
    @ApiModelProperty("买家名字")
    private String buyerName;
    @ApiModelProperty("卖家电话")
    private String buyerPhone;
    @ApiModelProperty("买家地址")
    private String buyerAddress;
    @ApiModelProperty("买家openid")
    private String buyerOpenid;
    @ApiModelProperty("订单总金额")
    private BigDecimal orderAmount;

    //订单状态 0新订单 1已完结 2已取消
    @ApiModelProperty("订单状态 0新订单 1已完结 2已取消")
    private OrderStatus orderStatus;
    //支付状态 0等待支付 1支付成功
    @ApiModelProperty("0等待支付 1支付成功")
    private PayStatus payStatus;

    private Date createTime;

    private  Date updateTime;

    @ApiModelProperty("订单详情列表")
    private List<OrderDetail> orderDetailList;
}
