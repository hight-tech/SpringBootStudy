package com.yang;

import com.yang.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot16MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setName("springboot22");
        book.setType("springboot22");
        book.setDescription("springboot22");
        mongoTemplate.save(book);
    }

    @Test
    void testFindAll(){
        List<Book> books = mongoTemplate.findAll(Book.class);
        System.out.println(books);
    }


}
