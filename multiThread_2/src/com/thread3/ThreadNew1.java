package com.thread3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 19:01 2021/4/5
 * @ Version:
 */
class NumThread implements Callable {//支持泛型，暂不使用

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;//装箱
    }
}

public class ThreadNew1 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();

        try {
            //get()返回值是FutureTask构造器参数Callable实现类重写call()方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
