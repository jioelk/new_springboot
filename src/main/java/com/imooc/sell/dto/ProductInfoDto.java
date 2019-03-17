package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品信息dto
 * @创建人 jioe
 * @创建时间 2019/3/2 13:55
 **/
@Data
public class ProductInfoDto {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private  String productDescription;

    @JsonProperty("icon")
    private String productIcon ;
}
