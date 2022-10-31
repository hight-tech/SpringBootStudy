package com.yang.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
