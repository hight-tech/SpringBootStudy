package com.yang;

import com.yang.domain.Book;
import com.yang.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@SpringBootTest
@Transactional
@Rollback()//回滚数据 true 会回滚 false 不会回滚
public class DaoTest {
    @Autowired
    private BookService bookService;
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("springboot4");
        book.setName("springboot4");
        book.setDescription("springboot4");
        bookService.save(book);
    }
}
