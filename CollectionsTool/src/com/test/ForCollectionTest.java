package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ForCollectionTest {
    /**
     * Collections：操作Collection、Map的工具类
     * 顺序相关（均为static方法）
     * reverse(List)：反转 List 中元素的顺序
     * shuffle(List)：对 List 集合元素进行随机排序
     * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     * 查找、替换
     * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
     * 给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
     * List 对象的所有旧值
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);
        System.out.println(list);
        //Collections.reverse(List list),原数组修改
        Collections.reverse(list);
        System.out.println(list);

        //Collections.shuffle(list)
        Collections.shuffle(list);//随机顺序
        System.out.println(list);
        //Collections.sort(lsit)
        Collections.sort(list);//升序
        System.out.println(list);
        //Collections.sort(List,Comparator)定制排序
        //Collections.swap(List,int ,int)交换指定下标元素位置
//        int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list, 4));
        System.out.println("******************************************");
//        void copy(List dest,List src)：将src中的内容复制到dest中
        //下面是错误的
       /* List dest = new ArrayList();
        Collections.copy(dest,list);//copy中会调研dest.size()判断长度，为0<list.size()异常*/
        //正确的
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest, list);
        System.out.println(dest);

    }

    /*
    同步方法：Collections 类中提供了多个 synchronizedXxx() 方法，
    该方法可使将指定集合包装成线程同步的集合，
    从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void synchronizedTest() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);

        //这样list1就是线程安全的，Map也类似
        List list1 = Collections.synchronizedList(list);
    }
}
