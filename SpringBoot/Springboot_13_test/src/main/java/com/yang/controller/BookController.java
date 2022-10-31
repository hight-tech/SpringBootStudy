package com.yang.controller;

import com.yang.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("books is runing......");
//        return "books getById";
//    }


    @GetMapping
    public Book getById(){
        System.out.println("books is runing......");
        Book book = new Book();
        book.setId(1);
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");
        return book;
    }

}
