package com.example.demo.service;

import com.example.demo.base.Book;
import com.example.demo.base.InventoryForMoveDTO;
import com.example.demo.base.ResultVO;
import com.shopwinner.saas.common.util.JsonUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2020/12/22 上午11:17
 */
@Component
public class TestService {
    public String getname(){
        return "get ioc bean success";
    }

    public static void main(String[] args) {
//        String json = "{\n" +
//                "  \"code\": 0,\n" +
//                "  \"msg\": \"\",\n" +
//                "  \"result\": {},\n" +
//                "  \"applicationName\": \"\"\n" +
//                "}";
//        ResultVO i = JsonUtil.fromJson(json, ResultVO.class);
//        System.out.println(i);
        BigDecimal a = new BigDecimal("11.11");
        BigDecimal b = new BigDecimal("10");

        System.out.println(a.multiply(b).setScale(0,BigDecimal.ROUND_DOWN));

    }

}
