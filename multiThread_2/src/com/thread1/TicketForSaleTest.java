package com.thread1;


/**
 * @ Description:三个窗口卖票,总票数100,使用Runnable接口方式实现
 * 1. 问题:出现重票,错票-->线程安全问题
 * 2. 原因:某线程操作车票尚未完成时,其他线程参与进来操作车票
 * 3. 解决:同时只允许一个线程操作车票(即使当前正在操作车票的出现阻塞也不允许其他线程操作)
 * <p>
 * 4. 在Java中,通过同步机制,来解决线程安全问题
 * 方式一:同步代码块
 * <p>
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 说明:1.操作(包括比较操作)共享数据的代码,即为需要被同步的代码
 * 2.共享数据:多个线程共同操作的变量
 * 3.同步监视器,俗称,锁。任何一个类的对象,都可以充当锁。
 * 要求：多个线程必须共用同一把锁！（Runnable接口方式实现的多线程由于只有一个对象tfs，保证了只有一把锁）
 * 补充：在实现Runnable接口方式实现的多线程方式中，可以考虑使用this充当同步监视器
 * 在继承创建多线程方式中，可以考虑使用当前类（类.class）充当同步监视器
 * 同步监视器不要包多或包少，可能会错，不只是效率问题
 * 方式二:同步方法（见java文件 com.thread2.TicketForSaleTest1）
 * 1. 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的
 * <p>
 * 5. 同步方式，解决了线程安全问题。--->好处
 * 操作同步代码是，只有一个线程参与。先党羽是单线程过程，效率低。-->缺点，但没办法
 * @ Author: Jay
 * @ Date: Create in 16:11 2021/4/2
 * @ Version:
 */
class TicketForSale implements Runnable {
    private int ticket = 100;
    //Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//this指的是TicketForSale的对象tfs //synchronized(obj)
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);//使得错票问题更明显,而不是无中生有
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号:" + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }
}

public class TicketForSaleTest {
    public static void main(String[] args) {
        TicketForSale tfs = new TicketForSale();
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
