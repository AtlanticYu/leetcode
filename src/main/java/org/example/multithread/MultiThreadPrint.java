package org.example.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/06 21:21
 */
public class MultiThreadPrint extends Thread {
    static int index;

    static int maxCount;
    static AtomicInteger count;
    static ReentrantLock lock = new ReentrantLock(true); // 公平锁比非公平锁要快一倍

    private int assign;
    private Runnable action;

    MultiThreadPrint(int assign, Runnable runnable) {
        this.assign = assign;
        if(assign == index) {
            this.assign = 0;
        }
        this.action = runnable;
    }

    @Override
    public void run() {
        while (count.get() <= maxCount) {
            lock.lock();
            if(count.get() <= maxCount && count.get() % index == assign) {
                this.action.run();
                count.incrementAndGet();
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadPrint.maxCount = 100000; // 总共打印多少次
        MultiThreadPrint.index = 10; // 5个线程
        MultiThreadPrint.count = new AtomicInteger(1);
        List<MultiThreadPrint> threads = new ArrayList<>();

        long start = System.currentTimeMillis();
        for(int i = 1 ; i <= MultiThreadPrint.index; i++) {
            int assign = i;
            MultiThreadPrint t = new MultiThreadPrint(assign, () -> {
                System.out.println((char) ('A' + assign - 1));
            });
            t.start();
            threads.add(t);
        }
        for (MultiThreadPrint thread : threads) {
            thread.join(); // 等待每个线程执行完毕
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
    }
}
