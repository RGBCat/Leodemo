package com.example.demo.base;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2020/12/15 下午7:57
 */
public class Stu {
    private Long id;
    private int age;
    private String name;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name56;
    private List<Book> books;



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Stu() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
