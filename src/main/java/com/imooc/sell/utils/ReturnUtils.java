package com.imooc.sell.utils;

import com.imooc.sell.dto.ResultDto;

/**
 * @创建人 jioe
 * @创建时间 2019/3/2 18:53
 **/
public class ReturnUtils {

    public static ResultDto success(Object object)
    {
        ResultDto resultDto =new ResultDto();
        resultDto.setCode(0);
        resultDto.setMsg("成功");
        resultDto.setData(object);
        return resultDto;
    }

   public static ResultDto success(){
        return success(null);
   }

    public static ResultDto fail(Integer code ,String message){

        ResultDto resultDto =new ResultDto();
        resultDto.setCode(code);
        resultDto.setMsg("message");
        return resultDto;
    }
}
