package com.example.demo.base;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
//        Book b = new Book();
//        b.setName("IamA");
//        Book c = new Book();
//        c.setName("IamC");
//        Book d = new Book();
//        d.setName("IamD");
//            b.setPrice(2);
//            c.setPrice(3);
//            d.setPrice(4);
//        books.add(a);
//        books.add(b);
//        books.add(c);
//        books.add(d);
//        books.forEach(book ->
//            book.setName(book.getName().toUpperCase(Locale.ROOT))
//        );
//            for (Book b1:books) {
//                System.out.println(b1.name);
//            }
//        Map<String,Integer> bookMap = books.stream().collect(Collectors.groupingBy(Book::getName,Collectors.summingInt(Book::getPrice)));
//            System.out.println(bookMap.get("IamA"));
////            System.out.println(books.get(0).getName());
////            Thread.sleep(30000);
////            System.out.println(books.get(0).getX());
//
//            //属性2
//            List<Long> attribute2IdList = Arrays.asList("1370282867032068102_1372934377255735341".split("_")).stream().map(s->Long.valueOf(s)).collect(Collectors.toList());
//
//            Long attribute2OptionId = attribute2IdList.get(1);
//            System.out.println(11111);
////            System.out.println(attribute1OptionId+"-----"+attribute2OptionId);\

            List<String> strings = new ArrayList<>();
            List<String> strings1 = new ArrayList<>();
            strings.add("a".toUpperCase(Locale.ROOT));
            strings.add("b  1111");
            strings.add("c 111");
            strings.add("d 111");
//            strings.stream().forEach(s -> s.toUpperCase(Locale.ROOT));

                strings.forEach(s1 -> strings1.add(s1.toUpperCase(Locale.ROOT)));
                 strings1.add("d");
       strings1.retainAll(strings);
            for (String s:strings1
            ) {
                System.out.println(s);

            }
        }



}