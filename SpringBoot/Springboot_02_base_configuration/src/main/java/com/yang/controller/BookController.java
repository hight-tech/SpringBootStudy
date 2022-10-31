package com.yang.controller;

import com.yang.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${user}")
    private String user1;
    @Value("${user1.name}")
    private String name;

    @Value("${likes[1]}")
    private String likes1;

    @Value("${tempDir}")
    private String tempDir;
    @Value("${tempDir2}")
    private String tempDir2;

    //使用一个对象将所有数据装配到一个数据中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;


    @GetMapping
    public String getById(){
        System.out.println("spring boot is runing");//spring boot is runing
        System.out.println("user===>" +user1);//user===>张三
        System.out.println("user1.name===>" +name);//user1.name===>张三123
        System.out.println("likes1===>" +likes1);//likes1===>music
        System.out.println("tempDir===>" + tempDir);//tempDir===>c:\windows\temp
        System.out.println("tempDir2===>" + tempDir2);//tempDir2===>c:\windows	emp 	1  	2 	3

        System.out.println("---------------------------------");
        System.out.println(env.getProperty("tempDir"));
        System.out.println(env.getProperty("tempDir2"));
        System.out.println(env.getProperty("likes[1]"));
        System.out.println("---------------------------------");
        System.out.println(myDataSource);
        return "spring boot is runing.....";
    }
}
