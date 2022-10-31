package com.yang;

import com.yang.config.Msgconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@SpringBootTest
@Import(Msgconfig.class)    // 导入配置bean 可以写数组{XXX.class,XXX.class}
public class ConfigurationTest {
    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }
}
