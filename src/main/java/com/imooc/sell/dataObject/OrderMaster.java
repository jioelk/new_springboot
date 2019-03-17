package com.imooc.sell.dataObject;

import com.imooc.sell.enumaaa.OrderStatus;
import com.imooc.sell.enumaaa.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @创建人 jioe
 * @创建时间 2019/3/3 18:42
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private  String  orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态 0新订单 1已完结 2已取消
    private OrderStatus orderStatus;
    //支付状态 0等待支付 1支付成功
    private PayStatus payStatus;

    private Date createTime;

    private  Date updateTime;
}
