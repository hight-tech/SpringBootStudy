package com.yang.dao;

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
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
    @Test
    public void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        int insert = bookDao.insert(book);
        System.out.println(insert);
    }
    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(3);
        book.setType("测试数据abcdefg");
        book.setName("测试数据abcdefg");
        book.setDescription("测试数据abcdefg");
        int res = bookDao.updateById(book);
        System.out.println(res);
    }
    @Test
    public void testDelete(){
        int res = bookDao.deleteById(3);
        System.out.println(res);
    }
    @Test
    public void testGetAll(){
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }
    @Test
    public void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
    @Test
    public void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","a");
        bookDao.selectList(qw);
    }

    @Test
    public void testGetBy2(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
//        if (name != null) lqw.like(Book::getName,name);
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }
}
