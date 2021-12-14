package com.example.demo.base;

import com.shopwinner.saas.common.util.Base62Util;
import com.shopwinner.saas.common.util.DateUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.All;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cn.hutool.crypto.CipherMode.encrypt;
import static org.bouncycastle.crypto.tls.HashAlgorithm.sha256;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/7/30 15:51
 */
public class DateDemo {
    public static void main(String[] args) {
//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
//        String batch = sdf.format(now);
//        String id = Base62Util.toBase62(1420728780195950662L);
//        System.out.println(batch+id);
        List<String> infoDTOS = new ArrayList<>();
        infoDTOS.add("111");
        infoDTOS.add("222");
        infoDTOS.add("333");
        Book n = new Book();
        List<String> infoDTOS1 = infoDTOS.stream().filter(s -> s.equals("111")).collect(Collectors.toList());
        System.out.println(infoDTOS1.size());
        System.out.println(infoDTOS.size());
//        String signature = encrypt("privateKey", sha256("message"));
    }
    public enum InventoryListTypeEnum {
        ALL("1","全部"),
        ALARMS("2", "警报"),
        SOLD_OUT("3", "售罄"),
        ;

        private String code;
        private String type;
        InventoryListTypeEnum( String code,String type) {
            this.code = code;
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
        public static InventoryListTypeEnum getValByCode(String code) {
            for (InventoryListTypeEnum listTypeEnum : InventoryListTypeEnum.values()) {
                if (code.equals(listTypeEnum.getCode()) ) {
                    return listTypeEnum;
                }
            }
            return null;
        }
    }



}
