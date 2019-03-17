package com.imooc.sell.enumaaa;

import lombok.Getter;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 16:40
 **/
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数不存在"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ISNULL(11,"商品库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    UPDATE_ERROR(15,"更新失败"),
    PAY_ERROR(16,"订单支付异常"),
    CART_EMPTY(17,"购物车为空")

            ;

    public Integer code;

    public   String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
