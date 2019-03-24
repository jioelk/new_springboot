package com.imooc.sell.Controller;/**
 * Created by MAIBENBEN on 2019/3/20.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/20 16:34
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping(value = "/weixin")
public class WeixinController {

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public void auth(@RequestParam("code")String code)
    {
        log.info("微信授权得到code");
       log.info("code={}",code);
       String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx17cf04d36064b568&secret=d54aa38de5a38f5e251ead307a58f909&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate=new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        log.info("result={}",result);
    }
}
