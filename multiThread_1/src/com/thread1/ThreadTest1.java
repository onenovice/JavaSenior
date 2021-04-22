package com.thread1;

/**
 * @ Description:多线程实现方式一:继承Thread
 * @ Author: Jay
 * @ Date: Create in 10:41 2021/4/1
 * @ Version:
 */
class Mythread_1 extends Thread {

    public Mythread_1() {
        super();
    }

    /**
     * 1.start（）:启动当前线程；调用当前线程mun（）
     * 2.run（）:通常需要重写 Thread:类中的此方法，将创建的线程要执行的操作声明在此方法中
     * 3.Thread.currentThread():静态方法,返回执行当前代码的线程
     * 4.getName():获取当前线程的名字
     * 5.setName():设置当前线程名字
     * 6.yield():释放当前CPU的执行权,但不一定切换
     * 7.join():在线程a中调用b的join方法,此时a进入阻塞,直到b执行结束才执行a
     * 8.sleep(long millitime):静态方法,参数毫秒,阻塞当前线程指定毫秒,之后接受CPU调度
     * 9.isAlive():判断当前线程是否存活
     * <p>
     * 线程优先级
     * 1.
     * MAX PRIORITY: 10
     * MIN PRIORITY: 1
     * NORM PRIIORITY: 5 -->默认
     * 2.如何获取和没置当前线程的优先级
     * getPriority（）:获取线程的优先
     * setPriority(int p):
     * <p>
     * 说明：高优先级的线理要抢占低优先级线程pu的执行权。但是只是从率上讲，并不意味着
     * 只有当高优先级执行后才执行低优先级
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        Mythread_1 t1 = new Mythread_1();
        t1.start();
        //或使用匿名子类调用
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if(i%2==0){
//                        System.out.println(i);
//                    }
//                }
//            }
//        }.start();
    }
}

