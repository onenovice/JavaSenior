package com.dateafterjava8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 19:42 2021/4/11
 * @ Version:
 */
public class JDK8DateTimeTest {
    public static void main(String[] args) {
        JDK8DateTimeTest jdk8DateTimeTest = new JDK8DateTimeTest();

        jdk8DateTimeTest.test3();
    }

    /*
    LocalDate、LocalTime、LocalDateTime分别代表日期、时间、日期和时间
    使用频率最高的是LocalDateTime
     */
    public void test1() {
//      now()获取当前日期和时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localdate);
//        System.out.println(localtime);
//        System.out.println(localDateTime);

        //of()设置指定的时间，日期，无偏移
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 4, 11, 19, 00, 00);
        System.out.println(localDateTime1);
        //getXxx()
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonth());//英文
        System.out.println(localDateTime.getMonthValue());//月，数字
        System.out.println(localDateTime.getMinute());
        //withXxx()设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);//返回新对象，不更改源对象
        System.out.println(localDate1);
        //
        LocalDateTime localDateTime2 = localDateTime.plusDays(1);
//        LocalDateTime localDateTime2=localDateTime.minusHours(1);//减
        System.out.println(localDateTime2);

    }

    /*
        Instant的使用
            类似于java,lang.Date类
     */
    public void test2() {
        //now()获取本初子午线对应标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//差八小时
        //根据时区设置偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //toEpochMilli()获取自格林威治时间1970年01月01日00时00分00秒起至现在毫秒数
        System.out.println(instant.toEpochMilli());
        //ofEpochMilli(long epochMilli) 通过给定毫秒数，获取Instance实例
        Instant instant1 = Instant.ofEpochMilli(1618143403468L);
        System.out.println(instant1);

    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
        类似SimpleDateFormat
     */
    public void test3() {
        //方式一：预定义格式：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(str1);
        //解析：字符串-->日期
        //默认以接口形式返回，具体看需要的是日期还是时间还是日期时间
        TemporalAccessor parse = formatter.parse("2021-04-12T10:21:07.239");//2021-04-12T10:21:07.239
        System.out.println(parse);

        //方式二：本地化相关格式。如 ofLocalizedDateTime()
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT ：适用LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//21-4-12 上午10:30

        //本地化相关格式。如ofLocalizedDate()
        //FormatStyle.FULL / FormatStyle.SHORT / FormatStyle.MEDIUM / FormatStyle.LONG适用LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);//注意后面是ofLocalizedDate

        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        //方式三：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor accessor = formatter3.parse("2020-01-01 03:03:03");
        System.out.println(accessor);


    }
}
