package com.test.demo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class InheritableThreadLocalDemo {
    //private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();


    public static void main(String[] args) {

    }

    public  static void InheritableThreadLocalMethod(){
        threadLocal.set("mainThread");
        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        new Thread(() -> {
            threadLocal.set("childThread");
            System.out.println(Thread.currentThread().getName() + "  " + threadLocal.get());
        }).start();
        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
    }


}
