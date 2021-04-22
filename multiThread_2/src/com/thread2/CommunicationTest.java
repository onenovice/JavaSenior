package com.thread2;

/**
 * wait():一旦等，会释放锁
 * notify():一旦执行此方法，就会唤醒一个被wait()的线程（如果有多个，就唤醒优先级高的）
 * notifyAll():唤醒所有被wait()的线程
 * <p>
 * 说明：
 * 1.三个方法必须使用在同步代码块或同步方法中
 * 2.三个方法调用者必须是同步代码块中或同步方法中的同步监视器，
 * 否则会出现IllegalMonitorStateException异常
 * 3.三个方法定义在java,lang.Object中
 *
 * @ Description:线程通信实例：使用两个线程打印1-100，交替打印
 * @ Author: Jay
 * @ Date: Create in 15:14 2021/4/5
 * @ Version:
 */
class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
//                    try {
//                        Thread.sleep(50);//不会释放锁
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();//一旦等，会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();

    }
}
