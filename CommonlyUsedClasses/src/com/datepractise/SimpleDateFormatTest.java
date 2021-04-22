package com.datepractise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * `Date`类的API不易于国际化，大部分被废弃了，`java.text.SimpleDateFormat` 类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
 * <p>
 * `SimpleDateFormat`是对日期`Date`类的格式化和解析
 * <p>
 * 1. 两个操作
 * <p>
 * 1.1 格式化：日期-->字符串
 * <p>
 * 1.2 解析：格式化逆过程：字符串-->日期
 * <p>
 * 2. `SimpleDateFormat`实例化
 *
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 18:29 2021/4/11
 * @ Version:
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        //解析
        //指定日期格式，否则默认
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = "2020-04-11 18:33:00";
        Date date = sdf.parse(format1);
        System.out.println(date);
        //字符串转换(解析)为数据库中Date格式
        String birth = "2020-01-01";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = sdf2.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date2.getTime());

        System.out.println(birthDate);
    }
}
