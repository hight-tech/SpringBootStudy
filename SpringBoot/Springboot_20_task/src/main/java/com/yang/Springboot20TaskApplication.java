package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启定时任务功能
@EnableScheduling
public class Springboot20TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20TaskApplication.class, args);
    }

}
