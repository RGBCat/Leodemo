package com.example.demo.util;

import com.example.demo.base.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/11/9 17:41
 */
public class TestMain {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setName("1");
        book2.setName("2");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        List<String> strings1 = bookList.stream().map(Book::getName).collect(Collectors.toList());
        for(String s : strings1){
            System.out.println(s);
        }
        List<String> strings = bookList.stream().map(Book::getName).filter(Objects::nonNull).collect(Collectors.toList());
        for(String s : strings){
            System.out.println(s);
        }
    }
}
