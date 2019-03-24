package com.imooc.sell.config;/**
 * Created by MAIBENBEN on 2019/3/20.
 */

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/20 17:51
 * @Description:wxMpService配置
 */
@Component
@PropertySource(value = {"classpath:/application.yml"})
public class WechatMpConfig {

    /*
    * 暂时用注解方式读取，对象映射方式不成功
    * */
    @Value("${mpAppId}")
    private String mpAppId;
    @Value("${mpAppSecret}")
    private String mpAppSecret;


    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(mpAppId);
        wxMpInMemoryConfigStorage.setSecret(mpAppSecret);
        return wxMpInMemoryConfigStorage;
    }
}
