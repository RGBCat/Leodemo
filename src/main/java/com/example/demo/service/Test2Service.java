package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/12/9 22:01
 */
@Service
public class Test2Service {
    @Autowired
    private Test1Service test1Service;
}
