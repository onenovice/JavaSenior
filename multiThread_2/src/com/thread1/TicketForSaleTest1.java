package com.thread1;

/**
 * @ Description:使用同步方法解决实现Runnable接口的线程安全
 * @ Author: Jay
 * @ Date: Create in 17:04 2021/4/2
 * @ Version:
 */
class TicketForSale1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
            //没写break
        }
    }

    private synchronized void show() {//完整的同步代码（不多不少）,此时的同步监视器是this
        //若是继承方式实现，必须写成private static synchronized void show()，此时锁是类(TicketForSale1.class)
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号:" + ticket);
            ticket--;
        }
    }
}

public class TicketForSaleTest1 {
    public static void main(String[] args) {
        TicketForSale1 tfs = new TicketForSale1();

        Thread t1 = new Thread(tfs);
        Thread t2 = new Thread(tfs);
        Thread t3 = new Thread(tfs);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}