package com.example.demo.base;

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
}
