//package com.example.demo.threaddemo;
//
//import com.example.demo.inter.StuInter;
//import com.example.demo.inter.StuInterImpl;
//import org.apache.poi.ss.formula.functions.T;
//
//import java.lang.annotation.Annotation;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ThreadDDD {
//    static volatile int a =1;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ExecutorService executorService =Executors.newCachedThreadPool();
//
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//              a = a+1;
//            }
//        }));
//
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = a-1;
//            }
//        }));
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = a+1;
//            }
//        }));
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = a-1;
//            }
//        }));
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = a+1;
//            }
//        }));
//        executorService.submit(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = a-1;
//            }
//        }));
//        Thread.sleep(1000);
//        System.out.println(a);
//
//    }
//}
