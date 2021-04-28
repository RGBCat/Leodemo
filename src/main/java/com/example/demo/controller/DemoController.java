package com.example.demo.controller;

import com.example.demo.config.Nameconfig;
import com.example.demo.util.PropertiesTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 样例
 * @author zz
 * @date 2020/2/28 17:30
 **/
@Controller
@RequestMapping("/aaa")
public class DemoController {
    @Autowired
    Nameconfig nameconfig;
    /**
     * 获取国际化配置
     * @param name 配置名称
     * @return String
     */
    @PostMapping(value = "/getProperties")
    public String getProperties (String name) {
        System.out.println(nameconfig.getName());
        System.out.println("incontroller name");
        return name;
    }


    @PostMapping(value = "/test1")
    public String test1 () {
        return "forward:/test2";
    }
    @PostMapping(value = "/test2")
    public String test2 () {
        return "forward:www.baidu.com";
    }
    @Autowired
    private PropertiesTools propertiesTools;

}
