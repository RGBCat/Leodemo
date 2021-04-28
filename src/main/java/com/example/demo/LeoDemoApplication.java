package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.ResourceBundle;
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan("com.example.demo.filter")
public class LeoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeoDemoApplication.class, args);

    }

}
