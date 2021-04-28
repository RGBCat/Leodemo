package com.example.demo.base;

import lombok.Data;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/1/12 13:06
 */
@Data
public class Book {
    String name;
    String price;

    public Book() {
    }

    public Book(String name, String price) {
        this.name = name;
        this.price = price;
    }
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
}
