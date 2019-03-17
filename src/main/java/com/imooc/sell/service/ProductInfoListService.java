package com.imooc.sell.service;

import com.imooc.sell.dto.CategoryDto;
import com.imooc.sell.dto.ResultDto;

public interface ProductInfoListService {

    public ResultDto<CategoryDto> productInfoList();
}
