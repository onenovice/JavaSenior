package com.datepractise;

import java.util.Calendar;
import java.util.Date;

/**
 * @ Description:抽象类，主要用于完成日期字段之间的相互操作
 * <p>
 * 获取实例方法
 * <p>
 * - 使用`Calendar.getInstance()`方法(常用)
 * - 调用它的子类`GregorianCalendar`的构造器。
 * 注意：获取月份时一月是0，以此类推；每周第一天是周日
 * @ Author: Jay
 * @ Date: Create in 18:55 2021/4/11
 * @ Version:
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(Calendar.DAY_OF_WEEK);


//      set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        add()
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
//        getTime()获得一个java.util.Date类对象
        Date date = calendar.getTime();
        System.out.println(date);
//      setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }


}
