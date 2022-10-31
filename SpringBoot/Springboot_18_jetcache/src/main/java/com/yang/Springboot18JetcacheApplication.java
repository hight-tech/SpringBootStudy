package com.yang;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//jetcache启用缓存的主开关
@EnableCreateCacheAnnotation
//jetcache开启方法缓存
@EnableMethodCache(basePackages = "com.yang")
public class Springboot18JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18JetcacheApplication.class, args);
    }

}
