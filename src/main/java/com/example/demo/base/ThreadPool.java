package com.example.demo.base;

import java.util.Date;

public class ThreadPool implements Runnable {

    private static ThreadPool threadPool = null;
    String name;

    public ThreadPool(String name){
        this.name = name;
    }
    @Override
    public void run() {
        doSomeThing();
    }

    public static synchronized Runnable getInstance(){
        if(threadPool == null){
            threadPool = new ThreadPool("getInstance");
        }
        return getInstance();
    }

    private void doSomeThing() {

        for (int i=0;i<10;i++){
            System.out.println((new Date()).toLocaleString() + "   " + Thread.currentThread().getName() + "执行" +i + ",name=" + name);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

