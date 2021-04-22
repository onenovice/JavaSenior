package com.thread1;

/**
 * 单纯的使用三个对象更改static变量会有线程安全问题
 * 需要同步解决
 *
 * @ Description:创建三个窗口卖票
 * @ Author: Jay
 * @ Date: Create in 15:33 2021/4/1
 * @ Version:1.0
 */
class TicketForSale extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":卖票,票号:" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class TicketForSaleTest {
    public static void main(String[] args) {
        TicketForSale t1 = new TicketForSale();
        TicketForSale t2 = new TicketForSale();
        TicketForSale t3 = new TicketForSale();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
