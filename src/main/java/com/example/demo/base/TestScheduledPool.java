package com.example.demo.base;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledPool {
    public static void main(String[] args) {
        /**             周期性线程池
         *                      ThreadPoolExecutor(corePoolSize,
         *                                      Integer.MAX_VALUE,
         *                                      0,
         *                                      NANOSECONDS,
         *                                      new DelayedWorkQueue(),
         *                                      Executors.defaultThreadFactory(),
         *                                      defaultHandler)
         *
         *  核心线程数，由用户自己指定，最大线程数为整数最大值
         *  超出核心线程数的线程空闲时间最大保持0纳秒（即空闲立刻销毁）
         *  默认工厂，默认拒绝策略
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        for (int i=0; i<2; i++){
            System.out.println((new Date()).toLocaleString());
            ThreadPool threadPool = new ThreadPool(""+i);
            /**
             *  schedule(Runnable command,long delay,TimeUnit unit)
             *  command:执行的任务，Runnable或Callable接口的实现类
             *  delay:延迟执行时间，即启动后，多长时间后执行
             *  unit：延迟时间的单位
             */
            //scheduledExecutorService.schedule(threadPool,2, TimeUnit.SECONDS);

            /**
             * scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit);
             *  command:执行的任务，Runnable的接口的的实现类的实例（该方法没有重载方法，所以只能是Runnable的继承类的实例）
             *  initialDelay:延迟执行时间，即启动后，多长时间后执行
             *  period:连续执行任务的周期，本次代码中，起了十个任务，这十个任务会重复执行。
             *          period代表十个任务执行中第一个任务开始执行到  下一组的十个任务的第一个任务开始执行的时间段
             *          此处要特别注意：若第一个十组任务执行未完成，但执行周期已经过了，第二个十组任务不会开始执行，
             *                          直到第一个十组任务执行完成，第二组才会开始执行
             *  unit:延迟时间的单位
             */
            //scheduledExecutorService.scheduleAtFixedRate(threadPool,2,5,TimeUnit.SECONDS);

            /**
             * scheduleWithFixedDelay与scheduleAtFixedRate的区别是：
             *  此方法的间隔时间是按照第一组任务执行结束才开始计算间隔时间的
             */
            scheduledExecutorService.scheduleWithFixedDelay(threadPool,2,5,TimeUnit.SECONDS);
        }
        //测试时，一定要注释shutdown()方法或者主线程睡一觉，否则不会打印，就会关闭线程池
        // scheduledExecutorService.shutdown();
    }
}

