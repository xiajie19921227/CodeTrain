package com.test.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerDemp {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        count.incrementAndGet();
        int a =0;
        //count.compareAndSet()
    }
}
