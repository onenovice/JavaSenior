package com.collection1;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ Description:注意：增强`for`循环
 * 无法进行赋值操作，因为更改局部变量,无法修改数组
 * @ Author: Jay
 * @ Date: Create in 11:06 2021/4/14
 * @ Version:
 */
public class ForTest {
    @Test
    public void ForTest() {
        Collection coll = new ArrayList();
        //add（）
        coll.add("AA");
        coll.add(123);
        coll.add(new String("Tom"));
        //for(集合元素类型 局部变量:集合对象)
        //内部仍然调用迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
}
