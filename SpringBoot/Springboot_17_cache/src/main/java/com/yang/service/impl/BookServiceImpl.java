package com.yang.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.dao.BookDao;
import com.yang.domain.Book;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Service
public class BookServiceImpl implements BookService {
    private HashMap<Integer,Book> cache=new HashMap<>();
    @Autowired
    private BookDao bookDao;
    @Override
    @Cacheable(value = "cacheSpace",key = "#id")
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }


//    @Override
//    public Book getById(Integer id) {
//        //如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
//        Book book = cache.get(id);
//        if (book == null) {
//            Book book1 = bookDao.selectById(id);
//            cache.put(id,book1);
//            return book1;
//        }
//        return book;
//    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }


    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

}
