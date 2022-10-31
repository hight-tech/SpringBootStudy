package com.yang.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private Integer id;
    private Integer id2;
    private Integer type;
    private String name;
    private String uuid;
    private Long publishTime;
}
