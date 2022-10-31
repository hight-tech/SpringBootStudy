package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// springboot开启缓存功能
@EnableCaching
public class Springboot17CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot17CacheApplication.class, args);
    }

}
