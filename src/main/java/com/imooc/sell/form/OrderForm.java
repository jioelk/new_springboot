package com.imooc.sell.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2019/3/17.
 */

@Data
public class OrderForm {
    @NotNull(message = "用户名不存在")
    private String name;

    @NotNull(message = "手机号码不存在")
    private String phone;

    @NotNull(message = "住址不存在")
    private String address;

    @NotNull(message = "openid不存在")
    private String openid;

    @NotNull(message = "购物车不能为空")
    private String items;
}
