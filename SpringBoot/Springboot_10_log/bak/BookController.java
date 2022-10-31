package com.yang.controller.bak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@RestController
@RequestMapping("/books")
public class BookController extends BaseClss {
    //创建记录日志的对象
//    private final static Logger log = LoggerFactory.getLogger(BookController.class);

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
