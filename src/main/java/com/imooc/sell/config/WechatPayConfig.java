package com.imooc.sell.config;/**
 * Created by Administrator on 2019/3/25.
 */

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatPayConfig
 * @Author jioe
 * @Date 2019/3/25 20:37
 **/

@Component
public class WechatPayConfig {
//     @Value("${mchId}")
//    private String mchId;
//    @Value("${mchKey}")
//    private String mchKey;
//     @Value("${keyPath}")
//    private String keyPath;
//    @Value("${mpAppId}")
//    private String mpAppId;
//    @Value("${mpAppSecret}")
//    private String mpAppSecret;
//    @Value("${notifyUrl}")
//    private String notifyUrl;

     @Bean
   public WxPayH5Config wxPayH5Config(){
         WxPayH5Config wxPayH5Config=new WxPayH5Config();
         wxPayH5Config.setAppId("wxd898fcb01713c658");
         wxPayH5Config.setAppSecret("d54aa38de5a38f5e251ead307a58f909");
         wxPayH5Config.setKeyPath("classpath:/h5.p12");
         wxPayH5Config.setMchId("1483469312");
         wxPayH5Config.setMchKey("C5245D70627C1F8E9964D494B0735025");
         wxPayH5Config.setNotifyUrl("http://jioe.mynatapp.cc/sell/pay/notify");
         return wxPayH5Config;
   }

   @Bean
   public BestPayServiceImpl bestPayService(){
       BestPayServiceImpl bestPayService=new BestPayServiceImpl();
       bestPayService.setWxPayH5Config(wxPayH5Config());
      return bestPayService;
   }
}
