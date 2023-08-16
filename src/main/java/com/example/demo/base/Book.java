package com.example.demo.base;

import com.example.demo.util.JsonUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/1/12 13:06
 */
@Data
public class Book {
    String name;
    int price;
    Integer size;
    Date creatTime;
    Boolean x;
    List<Long> pages;
    public Book() {
    }

    public static void main(String[] args) {
////        BigDecimal bigDecimal  = new BigDecimal("99999999999999990");
////        BigDecimal decimal  = bigDecimal.divide(new BigDecimal("1000"),0,BigDecimal.ROUND_DOWN);
////        String price = decimal.toString();
////        if(price.length()>14){
////            System.out.println("error");
////        }
////        Book b = new Book();
//////        b.setName(b.getName().toUpperCase(Locale.ROOT));
////        List<String> a = null;
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
////        System.out.println(simpleDateFormat.format(new Date()));
////        System.out.println(StringUtils.join(a,"、"));
////        List<String> strings = null;
////        System.out.println(CollectionUtils.isEmpty(strings));
//        System.out.println("".replace(" ","").toLowerCase(Locale.ROOT)); ;
        List<Stu> stus = new ArrayList<>();
        Stu stu = new Stu();
        Book b = new Book();
        b.setName("11111");
        List<Book> books = new ArrayList<>();
        books.add(b);
        stu.setBooks(books);
        stus.add(stu);
        books.get(0).setName("2222");
        System.out.println(JsonUtils.toJson(stus));
        stus.forEach(stu1 -> {

        });

    }

    public boolean testB(){
        return true;
    }
}
