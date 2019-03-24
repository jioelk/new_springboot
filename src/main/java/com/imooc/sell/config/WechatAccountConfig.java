package com.imooc.sell.config;/**
 * Created by MAIBENBEN on 2019/3/20.
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/20 18:13
 * @Description:微信用户配置
 */


@Component
@PropertySource(value = {"classpath:/application.yml"})
public class WechatAccountConfig {
    private   static  String mpAppId;
    private  static   String mpAppSecret;

    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public void setMpAppSecret(String mpAppSecret) {
        this.mpAppSecret = mpAppSecret;
    }

    public static String getMpAppId() {
        return mpAppId;
    }

    public static String getMpAppSecret() {
        return mpAppSecret;
    }
}
