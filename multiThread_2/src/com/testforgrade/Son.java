package com.testforgrade;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 14:41 2021/4/8
 * @ Version:
 */
public class Son extends Father {
    static {
        System.out.println("我是儿子的静态代码块");
    }

    {
        System.out.println("我是儿子的一般代码块");
    }

    public Son() {
        System.out.println("我是儿子的构造函数");
    }


}
