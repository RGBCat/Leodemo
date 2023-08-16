package com.example.demo.base;


import com.example.demo.util.JsonUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2023/3/13 11:13
 */
public class Test0313 {

        public static void main(String[] args) {
//                ArrayList<Book> list = new ArrayList<Book>();
//                ArrayList<Book> list2 = new ArrayList<Book>();
//                Book book1 = new Book();
//                Book book2 = new Book();
//                book1.setName("1");
//                book1.setPrice(1);
//                book2.setName("2");
//                book2.setPrice(1);
//                list.add(book1);
//                list.add(book2);
//                List<Integer> collect = list.stream().filter(Book -> (Book.getPrice() != 1)).map(Book::getPrice).collect(Collectors.toList());
//                System.out.println(collect);
//
//                List<String> collect3 = list2.stream().filter(b -> b.getName().equals("10")).map(Book::getName).collect(Collectors.toList());
//
////                List<Book> books2 = new ArrayList<>(collect1.values());
//                Map<String, Book> collect2 = list2.stream().collect(Collectors.toMap(Book::getName, book -> book));
////                Book book = collect2.get("1");
////                book.setPrice(10000);
////                System.out.println(JSON.toJSONString(collect2));
////                System.out.println(JSON.toJSONString(collect1));
//                List<Integer> ipIds = list.stream().map(Book::getSize).distinct().collect(Collectors.toList());
//                ipIds.remove(null);
//                ipIds.remove(0L);
//                System.out.println(ipIds.size());
//                System.out.println(JSON.toJSONString(1<7L));

                Stu<List<Book>> stu = new Stu();
                stu.setAge(11);
                List<Book> books = new ArrayList<Book>();
                Book book = new Book();
                stu.setResult(books);
                book.setSize(1);
                books.add(book);
                stu.setAge(11);
                Stu stu1 = new Stu();
                BeanUtils.copyProperties(stu,stu1);
                System.out.println(JsonUtils.toJson(stu1));

        }
        public static boolean get1(){
                int i =1;
                return i==1;
        }

}

