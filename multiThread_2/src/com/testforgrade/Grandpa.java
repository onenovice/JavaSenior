package com.testforgrade;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 14:37 2021/4/8
 * @ Version:
 */
public class Grandpa {
    static {
        System.out.println("我是爷爷的静态代码块");
    }

    {
        System.out.println("我是爷爷的一般代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷的构造函数");
    }
}
