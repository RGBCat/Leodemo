package com.example.demo.base;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2023/2/13 15:51
 */
public class Singleton {
    private static volatile  Singleton singleton = null;
    private Singleton(){};
    public static Singleton getSingleton(){
        if(null==singleton){
            synchronized (Singleton.class){
                if (null == singleton) {
                    singleton = new Singleton();
                }

            }

        }
        return singleton;
    }
}
