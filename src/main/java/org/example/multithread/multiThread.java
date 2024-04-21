package org.example.multithread;

// https://www.bilibili.com/video/BV1ez421C7Fz/?vd_source=5661e689a3517fe3b3e3e8c5c03f1ed6
public class multiThread {
    static int index=0;
    // 奇偶数校验本身没有必要加锁，会加剧两个线程的锁竞争，并且导致synchronized升级成重量级锁，造成性能浪费
    //优化方案：双检锁
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            while (index < 100) {
                synchronized (lock) {
                    if (index % 2 == 0 && index < 100) {
                        System.out.println("A");
                        index++;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (index<100){
                synchronized (lock) {
                    if (index % 2 == 1 && index < 100) {
                        System.out.println("B");
                        index++;
                    }
                }
            }
        }).start();
//        Thread.sleep(1000);
    }
}
