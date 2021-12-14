package com.example.demo.base;


import com.example.demo.util.JsonUtils;
import com.shopwinner.saas.common.util.CollectionUtil;
import com.shopwinner.saas.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Practice {
    public static Date parseStrToDate(String time, String timeFromat) {
        if (time != null && !time.equals("")) {
            Date date = null;

            try {
                DateFormat dateFormat = new SimpleDateFormat(timeFromat);
                date = dateFormat.parse(time);
            } catch (Exception var4) {
            }

            return date;
        } else {
            return null;
        }
    }

    public static String getExc(int i) {
        try {
            if (1 == 1) {
                System.out.println(1 / i);
            }
            return "try return";
        } catch (Exception e
        ) {
            System.out.println("catch");
        } finally {
            System.out.println(" \"成功\"");
        }
        return "final";
    }


        public static void main(String[] args) throws InterruptedException {
        List<Book> books = new ArrayList<>();
        Book a = new Book();
        a.setName("IamA");
        a.setPrice(1);
        Book b = new Book();
        b.setName("IamA");
        Book c = new Book();
        c.setName("IamC");
        Book d = new Book();
        d.setName("IamD");
            b.setPrice(2);
            c.setPrice(3);
            d.setPrice(4);
        books.add(a);
        books.add(b);
        books.add(c);
        books.add(d);
        Map<String,Integer> bookMap = books.stream().collect(Collectors.groupingBy(Book::getName,Collectors.summingInt(Book::getPrice)));
            System.out.println(bookMap.get("IamA"));
//            System.out.println(books.get(0).getName());
//            Thread.sleep(30000);
//            System.out.println(books.get(0).getX());

        }



}