package com.yang;

import com.yang.dao.BookDao;
import com.yang.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

}
