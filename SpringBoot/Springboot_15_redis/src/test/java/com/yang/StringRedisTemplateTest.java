package com.yang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@SpringBootTest
public class StringRedisTemplateTest {
//    private RedisTemplate redisTemplate;  //这个会有问题： 在客户端设置的值取不到

    @Autowired
    private StringRedisTemplate stringRedisTemplate;    // 这个与redis客户端操作是一样的

    @Test
    void get(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println(name);
    }
}
