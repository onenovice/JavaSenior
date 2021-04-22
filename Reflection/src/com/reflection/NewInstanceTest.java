package com.reflection;

import org.junit.Test;

/**
    通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void newInstanceTest() throws InstantiationException, IllegalAccessException {
        Class<Person> c1=Person.class;
        /*
        newInstance():创建对应的运行时类的对象（内部调用了运行时类的空参构造器）
        此方法要求：
        1.运行时类有空参构造器
        2.空参的构造器访问权限得够（通常public）

        在javabean中，要求提供空参构造器。原因：
        1.便于通过反射，创建运行时对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person p1=c1.newInstance();
        System.out.println(p1);
    }
}
