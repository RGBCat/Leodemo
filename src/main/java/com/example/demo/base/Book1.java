package com.example.demo.base;

import cn.hutool.Hutool;
import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/6/1 15:47
 */
@Data
public class Book1 extends Book {


    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @Override
    public boolean testB() {
        return false;
    }
    /**
     * 利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        StringBuilder specification = new StringBuilder();
        System.out.println(specification.toString());
        String a ="body=test&mchId=5a7bdfd22593414adb72df5f&nonceStr=yyv6YJP436wCkdpNdghC";
        String stringA="body=test&mchId=5a7bdfd22593414adb72df5f&nonceStr=yyv6YJP436wCkdpNdghC";
        String stringSignTemp=stringA+"&key=dd807a8e18b40153888e5a9864e70080"; //注:key为平台预分配的密钥key
        System.out.println(stringSignTemp);
        String str2 = SHACoder.encodeSHA256Hex(stringSignTemp).toUpperCase();
        System.out.println(str2);
        Book b = new Book();
        b.setName("1");
//        List<Book> addB = null ;
//        List<Book> books = new ArrayList<>();
//        books.add(b);
//        books.addAll(addB);
//        System.out.println(books.size());
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("a","a");
        jsonObject.set("b","b");
        jsonObject.set("c",b);
        jsonObject.set("d",null);
        Map<String,Object> map = new HashMap<>(jsonObject);
        System.out.println(map.size());
    }

}
