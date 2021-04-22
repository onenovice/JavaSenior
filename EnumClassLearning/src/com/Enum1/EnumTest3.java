package com.Enum1;

enum Season2 implements Info {//不含属性的枚举类
    Spring {
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
}

interface Info {
    void show();
}

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 16:15 2021/4/12
 * @ Version:
 */
public class EnumTest3 {
    public static void main(String[] args) {
        //实现接口Info，并且使得不同对象输出不同信息
        Season2 winter = Season2.WINTER;
        winter.show();
    }
}