package com.yang.service.impl;

import com.alicp.jetcache.anno.*;
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
    @Cached(name = "book_",key = "#id",expire = 60,cacheType = CacheType.REMOTE)
    //刷新缓存
//    @CacheRefresh(refresh = 10)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_",key = "#book.id",value = "#book")       //更新
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_",key = "#id")                        //删除
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

}
