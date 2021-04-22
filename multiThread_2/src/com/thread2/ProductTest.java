package com.thread2;

/**
 * 线程通信应用经典实例
 * 接口实现方式
 *
 * @ Description:生产者-消费者问题
 * @ Author: Jay
 * @ Date: Create in 15:44 2021/4/5
 * @ Version:
 */

class Producer implements Runnable {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品...");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }

}

class Clerk {//店员
    private int productCount = 0;

    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        Thread pt1 = new Thread(p);

        Consumer c = new Consumer(clerk);
        Thread ct1 = new Thread(c);

        pt1.setName("生产者 1");
        ct1.setName("消费者 1");

        pt1.start();
        ct1.start();

    }

}
