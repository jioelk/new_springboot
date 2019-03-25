package com.imooc.sell.utils;/**
 * Created by Administrator on 2019/3/25.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName JsonUtil
 * @Author jioe
 * @Date 2019/3/25 21:19
 **/
public class JsonUtil {

    public static String toJson(Object object)
    {
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
