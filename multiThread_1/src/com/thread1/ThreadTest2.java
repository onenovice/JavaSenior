package com.thread1;

/**
 * 创建多线程的方式二:实现 Runnable接口
 * 1.创建一个实现了 Runnable接口的类
 * 2.实现类去实现 Runnable中的抽象方法：run（）
 * 3.创建实现类的对象
 * 4.将此对象作为参数传到Thread类的构造器中，创建Thread类的对象
 * 5.通过 Thread类的对象调用 start()
 * <p>
 * 相较继承, 这种方式更好(**实现Runnable接口方式**),**优先选择**
 * ①没有类的单继承局限性
 * ②实现的方式更适合处理多个线程有共享数据的情况
 *
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 15:43 2021/4/1
 * @ Version:
 */
class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //不能直接使用getName(),因为不是Thread子类
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mt = new MThread();
        Thread t1 = new Thread(mt);
        t1.start();
        //不需要在创建MThread对象
        Thread t2 = new Thread(mt);
        t2.start();

    }
}
