package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import java.util.Locale;

/**
 * 国际化配置获取工具类
 * @author zz
 * @date 2020/2/28 17:00
 **/
@Slf4j
@Component
public class PropertiesTools {

    public String getProperties(String name) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(name, null, locale);
        } catch (NoSuchMessageException e) {
            log.error("获取配置异常!异常信息:{}", e);
        }
        return null;
    }

    @Autowired
    private MessageSource messageSource;

}
