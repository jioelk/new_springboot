package com.imooc.sell.service.serviceImpl;/**
 * Created by Administrator on 2019/3/25.
 */

import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.service.PayService;
import com.imooc.sell.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PayServiceImpl
 * @Author jioe
 * @Date 2019/3/25 20:35
 **/

@Service
@Slf4j
public class PayServiceImpl implements PayService

{

    private static final String ORDER_NAME="微信点餐系统";
    @Autowired
   private BestPayServiceImpl bestPayService;
    @Override
    public void create(OrderDto orderDto) {
        PayRequest payRequest=new PayRequest();
        payRequest.setOpenid(orderDto.getBuyerOpenid());
        payRequest.setOrderAmount(orderDto.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDto.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("微信支付 request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("微信支付 payResponse={}",JsonUtil.toJson(payResponse));
    }
}
