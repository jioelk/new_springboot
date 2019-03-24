package com.imooc.sell.Controller;/**
 * Created by MAIBENBEN on 2019/3/20.
 */

import com.imooc.sell.config.WechatAccountConfig;
import com.imooc.sell.config.WechatMpConfig;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @Auther: MAIBENBEN
 * @Date: 2019/3/20 18:20
 * @Description:
 */
@Controller
@RequestMapping(value = "/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;


    @RequestMapping(value = "/authorize",method = RequestMethod.GET)
    public String getAuth(@RequestParam(value="returnUrl")String returnUrl){
        //配置
        //调用方法
        String url="http://jioe.mynatapp.cc/sell/wechat/userInfo";
        String encode = URLEncoder.encode(url);
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
        return "redirect:"+redirectUrl;
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String userInfo(@RequestParam("code")String code,
                           @RequestParam("state")String returnUrl)
    {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
            log.error("微信网页授权={}",e);
            throw  new SellException(ResultEnum.WX_AUTHORITY_ERROR.getCode(),e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("openid:{}",openId);
        return "redirect:"+returnUrl+"?openid="+openId;
    }




}
