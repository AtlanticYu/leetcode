package org.example.multithread;

public class PrintABC {
    private static final Object lock = new Object();
    private static volatile int currentThread = 1; // 1: A, 2: B, 3: C
    private static final int count = 10;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentThread != 1) {
                            lock.wait();
                        }
                        System.out.print("A");
                        currentThread = 2;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentThread != 2) {
                            lock.wait();
                        }
                        System.out.print("B");
                        currentThread = 3;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentThread != 3) {
                            lock.wait();
                        }
                        System.out.print("C ");
                        currentThread = 1;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new ThreadA();
        Thread threadB = new ThreadB();
        Thread threadC = new ThreadC();

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
