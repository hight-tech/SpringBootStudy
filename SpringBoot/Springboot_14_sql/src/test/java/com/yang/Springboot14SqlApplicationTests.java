package com.yang;

import com.yang.dao.BookDao;
import com.yang.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot14SqlApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void test() {
        bookDao.selectById(3);
    }

    /*
    * 测试JDBCTemplate
    * */
    @Test
    void testJDBCTemplate(@Autowired JdbcTemplate jdbcTemplate){
        String sql="select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };
        List<Book> books = jdbcTemplate.query(sql, mapper);
        for (Book book: books) {
            System.out.println(book);
        }
    }


    @Test
    void testJDBCTemplateSave(@Autowired JdbcTemplate jdbcTemplate){
        String sql="insert into tbl_book values (3,'springboot1','springboot2','springboot3')";
        int update = jdbcTemplate.update(sql);
        System.out.println(update);

    }

}
