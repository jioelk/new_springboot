package com.imooc.sell.utils;

/**
 * @创建人 jioe
 * @创建时间 2019/3/10 17:22
 **/
public class RandomUtils {

    public static synchronized String getUniqueKey(){
      Integer random= (int)(Math.random()*1000000);
      return System.currentTimeMillis()+String.valueOf(random);
    }
}
