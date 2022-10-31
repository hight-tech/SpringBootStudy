package com.yang;

import com.yang.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bookController = run.getBean(BookController.class);
        System.out.println("book===>"+bookController);
    }

}
