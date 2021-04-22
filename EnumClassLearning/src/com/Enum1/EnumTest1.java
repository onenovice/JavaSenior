package com.Enum1;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 15:28 2021/4/12
 * @ Version:
 */
public class EnumTest1 {
    public static void main(String[] args) {
        Season s = Season.Spring;
        System.out.println(s);
    }


}

class Season {
    //3.提供当前枚举类的多个对象
    public static final Season Spring = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "银装素裹");
    //1.声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4.其他诉求2：toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}