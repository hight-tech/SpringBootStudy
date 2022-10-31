package com.yang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.Book;

public interface IBookService extends IService<Book> {
    Boolean saveBook(Book book);
    Boolean modify(Book book);
    Boolean delete(Integer id);

    IPage<Book> getPage(Integer currentPage,Integer pageSize);
    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book book);
}
