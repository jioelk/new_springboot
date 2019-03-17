package com.imooc.sell.enumaaa;

import lombok.Getter;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 16:44
 **/
@Getter
public class SellException extends  RuntimeException {

    public   Integer code;

    //不加public调用失败
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message)
    {
        super(message);
        this.code=code;
    }
}
