package com.yang;

import com.yang.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author yang
 * @Date 2022/8/1
 */
//properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties= {"test.prop=testValue123"})
//args属性可以为当前测试用例添加临时的命令行参数
//@SpringBootTest(args = {"--test.prop=testValue2"})
@SpringBootTest(properties= {"test.prop=testValue123"},args = {"--test.prop=testValue2"})
public class ProPertiesAndArgsTest {

    @Autowired
    private BookCase bookCase;
    @Value("${test.prop}")
    private String msg;
    @Test
    void testProperties(){
        System.out.println(msg);
        System.out.println(bookCase);
    }
}
