package com.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
获取指定运行时类结构：方法、属性、构造器
 */
public class ReflectionTest2 {

    @Test
    public void getFieldTest1() throws Exception{//不需要掌握，仅作为问题引入
        Class clazz=Person.class;
        //创建运行时类对象
        Person p = (Person)clazz.newInstance();
        //获取指定属性:要求public,限制太大不常用
        Field age=clazz.getField("age");
        //设置属性值
        //set()：参数1指明哪个对象，参数2：将此属性设置为多少
        age.set(p,11);
        //获取当前属性值
        //get():参数：获取哪个对象的当前属性
        int page=(int) age.get(p);
        System.out.println(page);
    }
    /*
     如何操作运行时类中的指定属性
    要求掌握
     */
    @Test
    public void getFieldTest() throws Exception {
        Class clazz=Person.class;
        Person p=(Person)clazz.newInstance();
        //1. 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性可访问
        name.setAccessible(true);
        //3.设置、获取指定对象此属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }

//    如何操作运行时类中的指定方法
        //要求掌握
    @Test
    public void getMethodTest() throws Exception {
    Class clazz=Person.class;
    Person p=(Person)clazz.newInstance();//较为灵活使用较多，99%
    //1. 获取运行时类中指定方法
        //getDeclaredMethod():参数1,：指明方法名；参数2：指明方法形参列表
    Method showNation=clazz.getDeclaredMethod("showNation",String.class);
    //2.保证当前方法可访问
    showNation.setAccessible(true);
    //3.调用方法的invoke():参数1：方法调用者；参数2：传入实参
            //invoke()方法的返回值即为对应类中方法的返回值
    Object nation = showNation.invoke(p, "中国");
    System.out.println(nation);

    System.out.println("************调用静态方法****************");
    /*Person类中静态方法
    private static void showMe(){
        System.out.println("我是一个好人！");
    }*/
    Method showMe = clazz.getDeclaredMethod("showMe");
    showMe.setAccessible(true);
    //调用的运行时类中的方法无返回值，invoke()返回值为null
    Object returnVal = showMe.invoke(Person.class);//写null也可以但不可以不写
    System.out.println(returnVal);
    }
    //如何操作运行时类中的指定构造器（不够灵活，使用较少）
    @Test
    public void getConstructorTest() throws Exception {
        Class clazz = Person.class;
        //private Person(String name) {
        //1.获取指定构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        //2.保证此构造器可访问
        constructor.setAccessible(true);
        //3.调用构造器创建运行时类对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);
    }
}
