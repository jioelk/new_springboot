package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @创建人 jioe
 * @创建时间 2019/3/2 13:53
 **/
@Data
public class CategoryDto {
    
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoDto> categoryFoods;

}
