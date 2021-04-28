package com.example.demo.inter;

import com.example.demo.config.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2020/11/24 下午12:20
 */
public class StuInterImpl implements StuInter {
    @Resource(name = "mailtaskExecutor")
    Executor mailtaskExecutor;
    @Override
    public void getstu() {

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
        Executor mailtaskExecutor= threadPoolConfig.asyncServiceExecutor();

        for(int i=0;i<200;i++){
            Runnable target;
            Thread thread = new Thread(new AutoTest());
            thread.start();
        }
        Thread.sleep(500);
        System.out.println(AutoTest.integer);
    }
    static class AutoTest implements Runnable{
        static AtomicInteger integer = new AtomicInteger(0);
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"********"+integer);
            integer.getAndAdd(1);
            System.out.println(Thread.currentThread().getName()+"********"+integer);
        }
    }
}
