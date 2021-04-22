package com.thread3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 10:01 2021/4/6
 * @ Version:
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定线程的操作。需要提供实现接口（Runnable或Callable）实现类的对象
        service.execute(new NumberThread());//适合使用Runnable
//        service.submit(Callable callable);//适合使用Callable,有返回值
        //3.关闭连接池
        service.shutdown();
    }
}
