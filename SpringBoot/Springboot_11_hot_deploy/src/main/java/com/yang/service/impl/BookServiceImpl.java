package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.dao.BookDao;
import com.yang.domain.Book;
import com.yang.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(page,null);
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(StringUtils.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(StringUtils.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage<Book> page = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(page,lqw);
    }
}
