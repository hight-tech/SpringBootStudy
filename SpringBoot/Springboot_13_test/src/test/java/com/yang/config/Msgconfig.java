package com.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@Configuration
public class Msgconfig {

    @Bean
    public String msg(){
        return "Bean Msg";
    }
}
