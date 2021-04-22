package com.collection1;

import org.junit.Test;

import java.util.*;

/**
 * /---Collection接口：单列集合，用来存储一个一个的对象
 * /---Set接口：存储无序的、不可重复的数据
 * /---HashSet:作为Set接口的主要实现类，线程不安全，可以存储null值
 * /---LinkedHashSet:作为HashSet的子类；遍历其内部数据时，可以按照添加顺序遍历
 * /---TreeSet：可以按照添加对象的指定属性，进行排序
 * 1. Set中没有额外定义的新的方法，使用的都是Collection中声明过的方法
 * * 2. 要求：向set中添加的数据，其所在的类一定要重写hashCode()和 equals()
 * 要求：重写的 hashcode()和 equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 17:22 2021/4/14
 * @ Version:
 */
public class SetTest {
    /**
     * 一、Set：存储无序的、不可重复的数据
     * 以HashSet举例：
     * 1.无序性:不等于随机性。存储的数据在顶层数组中并非按照数组所有的顺序添加，
     * 而是根据数据的哈希值决定。
     * <p>
     * 2.不可重复性：保证添加元素按照equals()方法判断时，不能返回true。
     * 即相同元素只能添加一个
     * 二、添加数据过程：以HashSet为例
     */
    @Test
    public void HashSetTest() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //LinkedHashSet作为HashSet的子类，添加数据的同时，每个数据还维护了两个引用，
    // 记录此数据的前一个数据和后一个数据
    //优点：对于频繁的遍历操作，效率高于HashSet
    @Test
    public void LinkedHashSetTest() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//输出顺序和添加顺序相同
        }
    }

    /*
        1.向TreeSet中添加数据要求是相同类的对象
        2.两种排序：自然排序(实现Comparable接口) 和 定制排序（Comparator接口，new TreeSet对象时参数时Comparator的对象）

        3. 自然排序中，比较两对象是否相同的标准为：compareTo()返回0，而不是equals()
        4. 定制排序中，比较两对象是否相同的标准为：compare()返回0，而不是equals()
     */
    @Test
    public void TreeSetTest() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(51);
        treeSet.add(12);
        treeSet.add(3);
        treeSet.add(41);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//输出顺序和添加顺序相同
        }
    }

}
