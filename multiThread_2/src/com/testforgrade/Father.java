package com.testforgrade;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 14:40 2021/4/8
 * @ Version:
 */
public class Father extends Grandpa {
    static {
        System.out.println("我是爸爸的静态代码块");
    }

    {
        System.out.println("我是爸爸的一般代码块");
    }

    public Father() {
        System.out.println("我是爸爸的构造函数");
    }
}
