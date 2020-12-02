package com.test.demo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ReentLockDemo {

    public static void main(String[] args) throws ParseException {
//        for(int i =0 ;i<10000;i++){
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"启动");
//                run();
//            }).start();
//        }
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse("2020-11-11T11:13");
        System.out.println(date);
    }

    public static void run(){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+"获得了锁");
        reentrantLock.unlock();
        ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();
    }

    
    
}
