package com.imooc.sell.dto;

import lombok.Data;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 18:12
 **/
@Data
public class CartDto {

    private String productId;

    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
