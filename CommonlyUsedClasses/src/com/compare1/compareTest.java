package com.compare1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * #### `Comparable`（自然排序）
 * <p>
 * 1. 像`String`，包装类等实现了`Comparable`接口，重写了`compareTo()`方法，给出了比较两对象大小的方式
 * <p>
 * 2. 重写`compareTo()`后，从小到大排列
 * <p>
 * 3. 重写`compareTo()`的规则：
 * <p>
 * > 如果当前对象this大 于形参对象obj，则返回正整数；
 * >
 * > 如果当前对象this小于形参对象obj，则返回 负整数；
 * >
 * > 如果当前对象this等于形参对象obj，则返回零。
 * <p>
 * 4. 自定义的类如果需要排序，可以让该类实现`Comparable`接口，重写`compareTo()`方法，在方法中指明如何排序
 * <p>
 * java.util.Comparator
 */
public class compareTest {


    public static void main(String[] args) {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("xiaomi", 1);
        arr[1] = new Goods("huawei", 6);
        arr[2] = new Goods("lenvo", 2);
        arr[3] = new Goods("dell", 4);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
/**方式二
 *
 当元素的类型没有实现`java.lang.Comparable`接口而又不方便修改代码

 或者,实现了`java.lang.Comparable`接口的排序规则不适合当前的操作，

 那 么可以考虑使用` Comparator`的对象来排序，强行对多个对象进行整体排序的比较。

 - 重写`compare(Object o1,Object o2)`方法，比较`o1`和`o2`的大小：

 > 如果方法返 回正整数，则表示`o1`大于`o2`；
 >
 > 如果返回0，表示相等；
 >
 > 返回负整数，表示`o1`小于`o2`
 */
        String[] arr1 = {"AA", "BB", "KK", "MM", "GG"};
        Arrays.sort(arr1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {//从大到小
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("类型不匹配!");
            }
        });
        System.out.println(Arrays.toString(arr1));
    }

}
