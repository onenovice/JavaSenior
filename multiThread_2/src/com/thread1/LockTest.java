package com.thread1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK5以后新增
 * 线程安全问题解决三：Lock锁
 *
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 14:31 2021/4/5
 * @ Version:
 */
class TicketForSale2 implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();//参数，公平，默认false

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定方法lock
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口" + Thread.currentThread().getName() + ",票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();//3.调用解锁方法:unlock()
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        TicketForSale2 tfs = new TicketForSale2();
        Thread t1 = new Thread(tfs);
        Thread t2 = new Thread(tfs);
        Thread t3 = new Thread(tfs);
        t1.setName("1");
        t2.setName("2");
        t3.setName("3");
        t1.start();
        t2.start();
        t3.start();
    }
}
