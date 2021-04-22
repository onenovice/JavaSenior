package com.thread1;

/**
 * 同步机制将单例模式中懒汉式改写为线程安全的
 *
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 13:48 2021/4/5
 * @ Version:
 */
public class BankTest {
}

/*①同步方法 懒汉式
 * ②或者选中要放进同步代码块的代码使用 ctrl + alt + T
 * 选择synchronized，将Bank.class作为锁
 * 上述方法效率低
 * */
class Bank {
    private static Bank instance = null;

    private Bank() {
    }

    ;
    //方式一：同步方法

    /**
     * public static synchronized Bank getInstance(){//静态方法的锁是类本身
     * if(instance==null){
     * instance = new Bank();
     * }
     * return instance;
     * }
     */
    //方式二：同步代码块
    /*
     public static Bank getInstance(){//静态方法的锁是类本身
         synchronized (Bank.class) {
             if(instance==null){
                 instance = new Bank();
             }
             return instance;
         }
     }*/
    //改进的方式二：效率更高
    //面试时要么写饿汉式，要么写这种
    public static Bank getInstance() {//静态方法的锁是类本身
        if (instance == null) {//不空等
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
                return instance;
            }
        }
        return instance;
    }
}