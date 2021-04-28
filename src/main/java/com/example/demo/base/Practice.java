package com.example.demo.base;


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


        public static void main(String[] args) {
            //属性1
            List<Long> attribute1IdList = Arrays.asList("1372934377087963154_1372934377142489167".split("_")).stream().map(s->Long.valueOf(s)).collect(Collectors.toList());

            Long attribute1OptionId = attribute1IdList.get(1);

            //属性2
            List<Long> attribute2IdList = Arrays.asList("1370282867032068102_1372934377255735341".split("_")).stream().map(s->Long.valueOf(s)).collect(Collectors.toList());

            Long attribute2OptionId = attribute2IdList.get(1);
            System.out.println(11111);
            System.out.println(attribute1OptionId+"-----"+attribute2OptionId);
        }



}