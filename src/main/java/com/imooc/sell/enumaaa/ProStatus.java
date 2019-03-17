package com.imooc.sell.enumaaa;

import lombok.Getter;

@Getter
public enum ProStatus {

    UP(0,"上架中"),
    DOWN(1,"已下架");

    private Integer code;

    private String message;

    ProStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
