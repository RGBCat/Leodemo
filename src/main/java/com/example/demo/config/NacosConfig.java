package com.example.demo.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Nacos配置管理器
 * @author zz
 * @date 2020/2/28 16:30
 **/
@Slf4j
@Component
public class NacosConfig {


    @Autowired
    public void init() {
        serverAddr = applicationContext.getEnvironment().getProperty("spring.cloud.nacos.config.server-addr");
        dNamespace = applicationContext.getEnvironment().getProperty("spring.cloud.nacos.config.dNamespace");
        if (StringUtils.isEmpty(dNamespace)) {
            dNamespace = DEFAULT_NAMESPACE;
        }
        initTip(null);
        initTip(Locale.CHINA);
        initTip(Locale.US);
        log.info("初始化系统参数成功!应用名称:{},Nacos地址:{},提示语命名空间:{}", applicationName, serverAddr, dNamespace);
    }

    private void initTip(Locale locale) {
        String content = null;
        String dataId = null;
        ConfigService configService = null;
        try {
            if (locale == null) {
                dataId = messageConfig.getBasename() + ".properties";
            } else {
                dataId = messageConfig.getBasename() + "_" + locale.getLanguage() + "_" + locale.getCountry() + ".properties";
            }
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
            properties.put(PropertyKeyConst.NAMESPACE, dNamespace);
            configService = NacosFactory.createConfigService(properties);
            content = configService.getConfig(dataId, DEFAULT_GROUP, 5000);
            if (StringUtils.isEmpty(content)) {
                log.warn("配置内容为空,跳过初始化!dataId:{}", dataId);
                return;
            }
            log.info("初始化国际化配置!配置内容:{}", content);
            saveAsFileWriter(dataId, content);
            setListener(configService, dataId, locale);
        } catch (Exception e) {
            log.error("初始化国际化配置异常!异常信息:{}", e);
        }
    }

    private void setListener(ConfigService configService, String dataId, Locale locale) throws com.alibaba.nacos.api.exception.NacosException {
        configService.addListener(dataId, DEFAULT_GROUP, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info("接收到新的国际化配置!配置内容:{}", configInfo);
                try {
                    initTip(locale);
                } catch (Exception e) {
                    log.error("初始化国际化配置异常!异常信息:{}", e);
                }
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    private void saveAsFileWriter(String fileName, String content) {
        String path = System.getProperty("user.dir") + File.separator + messageConfig.getBaseFolder();
        try {
            fileName = path + File.separator + fileName;
            File file = new File(fileName);
            FileUtils.writeStringToFile(file, content);
            log.info("国际化配置已更新!本地文件路径:{}", fileName);
        } catch (IOException e) {
            log.error("初始化国际化配置异常!本地文件路径:{}异常信息:{}", fileName, e);
        }
    }

    /**
     * 应用名称
     */
    @Value("${spring.application.name}")
    private String applicationName;
    /**
     * 命名空间
     */
    private String dNamespace;
    /**
     * 服务器地址
     */
    private String serverAddr;

    @Autowired
    private MessageConfig messageConfig;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    private static final String DEFAULT_GROUP = "DEFAULT_GROUP";

    private static final String DEFAULT_NAMESPACE = "78345af2-37f8-4b17-8e31-c58278cb2c0c";

}
