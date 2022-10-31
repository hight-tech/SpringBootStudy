package com.yang.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    public void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);

    }
    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("测试数据abcdefg");
        book.setName("测试数据abcdefg");
        book.setDescription("测试数据abcdefg");
        bookService.update(book);
    }
    @Test
    public void testDelete(){
        bookService.delete(13);
    }
    @Test
    public void testGetAll(){
        List<Book> books = bookService.getAll();
    }
    @Test
    public void testGetPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
