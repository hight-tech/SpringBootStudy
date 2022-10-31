package com.yang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.*;

/**
 * @Author yang
 * @Date 2022/8/1
 */

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟mvc的调用
@AutoConfigureMockMvc
public class WebTest {
    @Test
    void test(){

    }

    @Test
    void testWeb(@Autowired MockMvc mc) throws Exception {
        // 创建一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        mc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mc) throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        /*"/books1"
        java.lang.AssertionError: Status expected:<200> but was:<404>
        预期:200
        实际:404*/
        ResultActions actions = mc.perform(builder);
        //设定预期值，与真实值经行比较，成功 测试通过，失败 测试失败
        //定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用是成功的： 状态200
        ResultMatcher ok = status.isOk();
        //添加预计值到本次调用过程中经行匹配
        actions.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mc) throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        ResultActions actions = mc.perform(builder);
        //设定预期值，与真实值经行比较，成功 测试通过，失败 测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义预期执行结果
        ResultMatcher matcher = content.string("books getById");
        //添加预计值到本次调用过程中经行匹配
        actions.andExpect(matcher);
    }

    @Test
    void testJson(@Autowired MockMvc mc) throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        ResultActions actions = mc.perform(builder);
        //设定预期值，与真实值经行比较，成功 测试通过，失败 测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义预期执行结果
        ResultMatcher matcher = content.json("{\"id\":1,\"name\":\"springboot1\",\"type\":\"springboot\",\"description\":\"springboot\"}");
        //添加预计值到本次调用过程中经行匹配
        actions.andExpect(matcher);
    }

    @Test
    void testContentType(@Autowired MockMvc mc) throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        ResultActions actions = mc.perform(builder);
        //设定预期值，与真实值经行比较，成功 测试通过，失败 测试失败
        //定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //定义预期执行结果
        ResultMatcher matcher = header.string("Content-Type", "application/json");
        //添加预计值到本次调用过程中经行匹配
        actions.andExpect(matcher);
    }

    @Test
    void testGetById(@Autowired MockMvc mc) throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/books");
        ResultActions actions = mc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        actions.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher matcher = header.string("Content-Type", "application/json");
        actions.andExpect(matcher);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher matcher2 = content.json("{\"id\":1,\"name\":\"springboot\",\"type\":\"springboot\",\"description\":\"springboot\"}");
        actions.andExpect(matcher2);

    }
}
