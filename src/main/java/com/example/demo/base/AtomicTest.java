package com.example.demo.base;

/**
 * @author DUCHONG
 * @since 2019-01-07 19:11
 **/
public class AtomicTest {

    public static void main(String[] args) {
        Byte b = 1;
        AtomicThread atomicTest=new AtomicThread();
        for (int i=1;i<=20;i++){
            b.hashCode();
            new Thread(atomicTest).start();
        }
    }
}

     class  AtomicThread implements Runnable {

    private  int num=1;
    @Override
    public void run() {
        try {
            Thread.sleep(300);
            System.out.println(getNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNum(){
        return num++;
    }
}