package com.yang.dao.impl;

import com.yang.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is runing...");
    }
}
