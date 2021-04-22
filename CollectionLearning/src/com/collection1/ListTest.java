package com.collection1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * /---Collection接口：单列集合，用来存储一个一个的对象
 * /---List接口：存储有序的、可重复的数据
 * /---ArrayList:作为List的主要实现类，效率高，线程不安全；底层使用Object[] elementData存储
 * /---LinkedList：线程不安全;对于频繁的插入、删除操作，使用效率比ArrayList高；底层使用双向链表存储
 * /---Vector:作为List的古老实现类；线程安全，效率不高；底层使用Object[] elementData存储
 * 面试题
 * ArrayList、LinkedList、Vector异同？
 * 同：都实现了List接口；存储数据特点相同：有序、可重复的数据；
 * 异：见上面
 */
public class ListTest {
    /**
     * 除继承自Collection的方法，还有一些根据索引操作集合元素的方法
     * 常用：
     * 增:add(Object) /addAll(Collection eles)
     * 删:remove(int index)/remove(Object ele)
     * 改:set(int index, Object ele)
     * 查:get(int index)
     * 插:add(int index, Object ele) / addAll(int index, Collection eles)
     * 长度：size()
     * 遍历：Iterator/增强for循环/普通循环
     */
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new String("Tom"));
        System.out.println(list);
        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "插入下标1的位置");
        System.out.println(list);
        //boolean addAll(int index, Collection eles)
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);//list.add(list1)会把list1当作整体添加进list
        System.out.println(list);
        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(2));
        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在返回-1
        System.out.println(list.indexOf("Tom"));
        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf("Tom"));
//      Object remove(int index):移除指定index位置的元素，并返回此元素
        //boolean remove(Object obj)//注意obj不能是int型，int会被当成索引
        //删除具体元素是返回是否删除成功
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

//      Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(0, 123);
        System.out.println(list);
//      List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合(左闭右开)
        List subList = list.subList(1, 3);
        System.out.println(subList);
        System.out.println(list);//本身不变
    }

}
