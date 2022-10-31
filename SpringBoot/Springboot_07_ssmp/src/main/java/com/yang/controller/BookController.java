package com.yang.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yang.controller.utils.R;
import com.yang.domain.Book;
import com.yang.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Author yang
 * @Date 2022/7/27
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        if (book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        // 如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){
//        System.out.println("book参数==》"+book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        // 如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值-
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
