package com.imooc.sell.service.serviceImpl;

import com.imooc.sell.dataObject.ProductCategory;
import com.imooc.sell.dataObject.ProductInfo;
import com.imooc.sell.dto.CategoryDto;
import com.imooc.sell.dto.ProductInfoDto;
import com.imooc.sell.dto.ResultDto;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductInfoListService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.ReturnUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人 jioe
 * @创建时间 2019/3/2 16:51
 **/
@Service
public class ProductInfoListServiceImpl implements ProductInfoListService {

    @Autowired
    private ProductInfoService  productInfoService;

    @Autowired
    private CategoryService  categoryService;

    @Override
    public ResultDto productInfoList() {
        //查询出所有上架商品
        List<ProductInfo> upAll = productInfoService.findUpAll();
        //查询所有上架商品的类目
        List<Integer> categoryTypes = upAll.stream().map(m -> m.getCategoryType()).collect(Collectors.toList());
        //搜出所有类目的数据库记录
        List<ProductCategory> categorys = categoryService.findByCategoryTypeIn(categoryTypes);

        List<CategoryDto> categoryDtoList=new ArrayList<>();
        for (ProductCategory productCategory:categorys)
        {
            //这里是个大坑 创建对象时要注意了！！！！！！！
            //创建在外面时for循环第二遍时把它覆盖了
            CategoryDto categoryDto=new CategoryDto();
            categoryDto.setCategoryType(productCategory.getCategoryType());
            categoryDto.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoDto> ProList=new ArrayList<>();
            for (ProductInfo productInfo:upAll)
            {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType()))
                {
                    ProductInfoDto productInfoDto=new ProductInfoDto();
                    BeanUtils.copyProperties(productInfo,productInfoDto);
                    ProList.add(productInfoDto);
                }
            }
            categoryDto.setCategoryFoods(ProList);
            categoryDtoList.add(categoryDto);
        }




        return ReturnUtils.success(categoryDtoList);
    }
}
