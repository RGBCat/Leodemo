package com.example.demo.base;

import lombok.Data;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import java.util.Date;

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
    public Book() {
    }


    public boolean testB(){
        return true;
    }
}
