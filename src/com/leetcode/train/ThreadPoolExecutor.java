package com.leetcode.train;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor {
    public ThreadPoolExecutor(
            int corePoolSize,//1. 核心线程数量
            int maximumPoolSize,//2. 最大线程数量
            long keepAliveTime,//3. 最大空闲时间
            TimeUnit unit, //4.时间单位
            BlockingQueue<Runnable> workQueue,//5.任务队列
            ThreadFactory threadFactory,//6.线程工厂
            RejectedExecutionHandler handler//7.饱和处理机制
    )
    {}
}
