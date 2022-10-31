package com.yang.service;

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
public class BookServiceTest {
    @Autowired
    private IBookService bookService;
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
        book.setId(14);
        book.setType("测试数据abcdefg");
        book.setName("测试数据abcdefg");
        bookService.updateById(book);
    }
    @Test
    public void testDelete(){
        bookService.removeById(13);
    }
    @Test
    public void testGetAll(){
        List<Book> books = bookService.list();
    }
    @Test
    public void testGetPage(){
        Page<Book> page1 = new Page<>(2, 5);
        IPage<Book> page = bookService.page(page1);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
