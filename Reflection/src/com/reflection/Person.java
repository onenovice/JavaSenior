package com.reflection;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 2:34 2021/4/21
 * @ Version:
 */
public class Person {
    private String name;
    public int age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我是中国人");
        return nation;
    }
    private static void showMe(){
        System.out.println("我是一个好人！");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
