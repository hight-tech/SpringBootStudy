 package com.yang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("spring boot 02 is runing");

        log.debug("debug=====");
        log.info("info=====");
        log.warn("warn=====");
        log.error("error=====");
        return "spring boot 02 is runing.....";
    }
}
