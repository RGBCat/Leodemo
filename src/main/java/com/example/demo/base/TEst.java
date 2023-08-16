package com.example.demo.base;

import com.example.demo.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2022/3/1 17:10
 */
public class TEst {
    public static void main(String[] args) {
        Stu stu1 = new Stu();
        stu1.setAge(1);
        stu1.setBooks(new ArrayList<>());
        Stu stu2 = new Stu();
        stu2.setAge(1);
        Stu stu3 = new Stu();
        stu3.setAge(1);
        Stu stu4 = new Stu();
        stu4.setAge(2);
        Stu stu5 = new Stu();
        stu5.setAge(4);
        List<Stu> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stu2.setAge(1);
        stu3.setAge(1);
//        stuList = stuList.stream().filter(stu -> stu.getAge()>53).collect(Collectors.toList());
//        System.out.println(JsonUtils.toJson(stuList));
//        List<Book> books = new ArrayList<>(stu1.getBooks());
//        books.add(new Book());
//        System.out.println(stu1.getBooks().size());
        System.out.println(JsonUtils.toJson(stuList.get(2)));
        List<Integer> collect = stuList.stream().map(Stu::getAge).distinct().collect(Collectors.toList());
        System.out.println(JsonUtils.toJson(collect));
    }
}
