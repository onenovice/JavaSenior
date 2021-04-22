package com.collection1;

import org.junit.Test;

import java.util.*;

/**
 * @ Description: Collection接口方法测试
 * 像Collection接口的实现类的对象中添加数据obj时，要求obj类重写equals()
 * @ Author: Jay
 * @ Date: Create in 19:40 2021/4/13
 * @ Version:
 */
public class CollectionTest {
    @Test
    public void CollectionTest() {
        Collection coll = new ArrayList();
        //add（）
        coll.add("AA");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(new Date());
        System.out.println(coll);//toString()
        //addAll(Collection coll)添加coll中的元素进当前集合
        Collection coll1 = new ArrayList();
        coll1.add("BB");
        coll1.addAll(coll);
        System.out.println(coll1);

        //clear()清空容器
        coll1.clear();
        System.out.println(coll1.isEmpty());
        //contains(Object obj)
        //会调用obj对象所在类的equals（）方法
        System.out.println(coll.contains("AA"));
        //如果是自定义类，没有重写equals方法会使用Object的，直接比较地址
        boolean contains = coll.contains(new String("Tom"));
        System.out.println(contains);

        //containsAll(Collection coll)判断coll中所有元素都在当前集合
        //会返回Arrays的内部类ArrayList和一般的ArrayList会有差别
        Collection coll2 = Arrays.asList(123, "Tom");
        System.out.println(coll.containsAll(coll2));

        //remove(Object obj)
        coll.remove(123);//也要求重写equals()
        System.out.println(coll);
        //removeAll(Collection coll)//差集：移除当前集合中coll容器所有元素
        //即只保留差集给当前集合
        Collection coll3 = Arrays.asList("AA", "Tom1");
        coll.removeAll(coll3);
        System.out.println(coll);
        //retainAll(Collection coll):交集：获取当前集合和coll的交集，并返回给当前集合
        //只保留交集给当前集合
        coll.retainAll(coll2);
        System.out.println(coll);

        System.out.println("*********equals()**********");
        //equals(Object obj):两集合是否相同（是否要求顺序，看集合本身是否有序）
        Collection coll4 = Arrays.asList(123, "Tom");
        Collection coll5 = Arrays.asList("Tom", 123);
        //因为ArrayList要求有序，所以equals比较要求顺序一致
        System.out.println(coll2.equals(coll4));
        System.out.println(coll2.equals(coll5));

        //hashCode()返回当前对象哈希值
        System.out.println(coll.hashCode());
        //集合-->数组：toArray()
        System.out.println("***********toArray()**********");
        Object[] arr = coll2.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //数组-->集合
        List<String> list = Arrays.asList(new String[]{"AA", "CC"});
        //注意
        List<int[]> list2 = Arrays.asList(new int[]{123, 456});
        System.out.println(list2.size());//会误以为是一个元素，要么采用Integer数组，要么写成asList（123,456）


    }

    @Test
    public void IteratorTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add(123);
        coll.add(new String("Tom"));
        //iterator():返回迭代器Iterator接口的实例，用于遍历集合元素，在Iterator.java中
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //remove()
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            if ("Tom".equals(obj)) iterator1.remove();
            //调用remove()前必须调用next();
            // 不能连续重复调用remove()删除同一元素
        }
        Iterator iterator3 = coll.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }

}
