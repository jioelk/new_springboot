package com.imooc.sell.dataObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.utils.DateToLongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @创建人 jioe
 * @创建时间 2019/3/3 19:23
 **/
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private  String detailId;

    private  String orderId;

    private  String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private  String productIcon;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = DateToLongSerializer.class)
    private  Date updateTime;
}
