package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2020/12/25 下午12:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "leo")
@RefreshScope
public class Nameconfig {
    private String name;
}