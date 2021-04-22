package com.Enum1;

enum Season1 {
    //1.多个对象之间使用逗号分隔开，最后用分号
    //没有属性的话就不要（）了
    Spring("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "银装素裹");
    //2.声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求：获取枚举类对象属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 15:51 2021/4/12
 * @ Version:
 */
public class EnumTest2 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);//SUMMER
        System.out.println(Season1.class.getSuperclass());//class java.lang.Enum

        //常用方法：
        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //valueOf(String str)根据名为str的枚举类对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);//默认调用toString()
        //toString()返回当前枚举对象常量的名称

    }
}