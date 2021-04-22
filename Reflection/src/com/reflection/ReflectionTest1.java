package com.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 2:33 2021/4/21
 * @ Version:
 */
public class ReflectionTest1 {
    /*
    反射之前，对于Person类能实现的操作
     */
    @Test
    public void test() {
        Person p1 = new Person("Tom", 15);
        p1.age = 20;
        System.out.println(p1);
        p1.show();
        //在Person外部无法调用内部私有结构。
        //比如：name属性和showNation()方法以及四有构造器
    }

    /*
    有反射后
     */
    @Test
    public void reflectionTest1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(obj);
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("**********************");
        //通过反射，可以调用Person类的私有结构
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "ZhangSan");
        System.out.println(p1);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);

    }
    //疑问：通过直接new的方式或反射的方式都可以调用公共结构，开发中使用哪种？
    //建议：直接new的方式
    //什么时候使用反射：反射的特征：动态性
    //疑问：反射机制与面向对象中的封装性是不是矛盾？如何看待这两个技术？
    //不矛盾。

    /*
    关于`java.lang.Class`理解

1. 类的加载过程：程序经过`javac.exe`命令以后，会生成一个或多个字节码文件（.class结尾），接着我们使用`java.exe`命令对摸个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类就作为Class的一个实例。

2. 换言之，Class的实例就对应着一个运行时类
3. 加载到内存中的运行时类，会缓存一定时间。在此时间之内，我们可以通过不同方式来获取此运行时类。
     */
    /*
    获取Class实例的四种方式
     */
    @Test
    public void reflectionoTest2() throws ClassNotFoundException {
        //方式1：调用运行时类的属性：class
        Class c1 = Person.class;
        System.out.println(c1);
        //方式2：通过运行时类的对象
        Person p1 = new Person();
        Class c2 = p1.getClass();
        System.out.println(c2);
        //方式3：调用Class的静态方法：forName(String classPath)   使用多
        Class c3 = Class.forName("com.reflection.Person");
        System.out.println(c3);
        //方式4：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.reflection.Person");
        System.out.println(c4);
        //都是同一个
        System.out.println(c1 == c2);
        System.out.println(c3 == c2);
    }

    /*
    哪些类型有Class对象
     */
    @Test
    public void test1() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }

    /*
    对于自定义类，使用系统类加载器进行加载

调用系统类加载器的`getParent()`:获取扩展类加载器

调用扩展类加载器的 `getparent()`:无法获取引导类加载器

引导类加载器主要负责加载java的核心类库，无法加载自定义类
     */
    //Properties:读取配置文件
    @Test
    public void test2() {
        InputStream is = null;
        try {
            Properties pros = new Properties();
            //方式一：配置文件默认在当前Module下
//        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
//        pros.load(fis);
            //方式二：配置文件默认在当前Module的src下
            ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
            is = classLoader.getResourceAsStream("jdbc1.properties");
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            System.out.println("user=" + user + ",password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
