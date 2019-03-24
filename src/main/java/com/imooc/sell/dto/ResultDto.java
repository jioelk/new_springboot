package com.imooc.sell.dto;

import lombok.Data;

/**
 * @创建人 jioe
 * @创建时间 2019/3/2 13:52
 **/
@Data
public class ResultDto<T> {
    public   Integer code;

    public String msg;
    //泛型T将类型限制为Object
    //对于List<T>,本身是个泛型，而将类型限定为Object
    //，即List<Object>,
    //可以放任意类型
    public T data;

    public ResultDto() {}

    public ResultDto(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
