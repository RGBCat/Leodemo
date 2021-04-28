package com.example.demo.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 国际化配置
 * @author zz
 * @date 2020/2/28 15:38
 **/
@Data
@RefreshScope
@Component
@ConfigurationProperties(prefix = "spring.messages")
public class MessageConfig {

    /**
     * 国际化文件目录
     */
    private String baseFolder;

    /**
     * 国际化文件名称
     */
    private String basename;

    /**
     * 国际化编码
     */
    private String encoding;

    /**
     * 缓存刷新时间
     */
    private long cacheMillis;

}
