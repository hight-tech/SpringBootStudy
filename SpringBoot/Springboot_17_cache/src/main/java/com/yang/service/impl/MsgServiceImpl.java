package com.yang.service.impl;

import com.yang.dao.BookDao;
import com.yang.domain.Book;
import com.yang.service.BookService;
import com.yang.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author yang
 * @Date 2022/7/26
 */
@Service
public class MsgServiceImpl implements MsgService {


    private HashMap<String,String> cache = new HashMap<>();
    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele,code);
        return code;
    }

    @Override
    public Boolean check(String tele, String code) {
        String queryCode = cache.get(tele);
        return code.equals(queryCode);
    }
}
