package com.imooc.sell.enumaaa;

import lombok.Getter;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 16:40
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ISNULL(11,"商品库存不足"),
    ORDER_NOT_EXIST(12,"商品不存在"),
            ;

    public Integer code;

    public   String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
