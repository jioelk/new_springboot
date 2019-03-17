package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.Dao.ProductInfoDao;
import com.imooc.sell.dto.CartDto;
import com.imooc.sell.enumaaa.ProStatus;
import com.imooc.sell.dataObject.ProductInfo;
import com.imooc.sell.enumaaa.ResultEnum;
import com.imooc.sell.enumaaa.SellException;
import com.imooc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService
{
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public void increaseStock(List<CartDto> cartList) {

    }

    @Override
    public void decreaseStock(List<CartDto> cartList) {
        for (CartDto cartDto:cartList) {
            String productId = cartDto.getProductId();
            ProductInfo one = productInfoDao.findOne(productId);
            if(one==null)
            {
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int i = one.getProductStock() - cartDto.getProductQuantity();
            if(i<0)
            {
               throw new SellException(ResultEnum.PRODUCT_STOCK_ISNULL);
            }
            one.setProductStock(i);
            productInfoDao.save(one);
        }
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        PageRequest request=new PageRequest(0,2);
        return productInfoDao.findAll(request);
    }

    @Override
    public List<ProductInfo> findUpAll()
    {
        return productInfoDao.findByProductStatus(ProStatus.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo)
    {
        return productInfoDao.save(productInfo);
    }



}
