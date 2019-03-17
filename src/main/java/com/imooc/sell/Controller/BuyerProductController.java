package com.imooc.sell.Controller;

import com.imooc.sell.dto.ResultDto;
import com.imooc.sell.service.ProductInfoListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 买家商品
 * @创建人 jioe
 * @创建时间 2019/3/2 13:41
 **/
@Api(tags ="买家商品")
@RestController
@RequestMapping("/buyer")
public class BuyerProductController {

    @Autowired
    private ProductInfoListService productInfoListService;

    @ApiOperation(value = "测试获取resultDto")
    @RequestMapping(path = "/product/list",method = RequestMethod.GET,produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResultDto findList(){
        return productInfoListService.productInfoList();
    }
}
