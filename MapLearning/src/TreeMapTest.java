import org.junit.Test;

import java.util.*;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 19:56 2021/4/15
 * @ Version:
 */
public class TreeMapTest {
    //自然排序
    @Test
    public void TreeMapTest1() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Tom", 24);
        User u3 = new User("Marry", 23);
        User u4 = new User("Jack", 23);
        User u5 = new User("Rose", 24);
        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 76);
        map.put(u4, 100);
        map.put(u5, 45);

        //遍历
        Set entryMap = map.entrySet();
        Iterator iterator = entryMap.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());

        }
    }

    //定制排序：重写了compare方法后，比较key是否相等时就会调用compare比较
    //下面例子中，compare()只涉及age属性，所以插入时年龄相同的对象会被当做key相同
    @Test
    public void TreeMapTest2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 23);
        User u3 = new User("Marry", 23);
        User u4 = new User("Tom", 26);
        User u5 = new User("Rose", 24);
        map.put(u1, 98);
        map.put(u2, 89);//无法插入，因为年龄相同，compare()返回0
        map.put(u3, 76);//修改了u1的value值为76
        map.put(u4, 100);//年龄不同，不同key
        map.put(u5, 45);

        //遍历
        Set entryMap = map.entrySet();
        Iterator iterator = entryMap.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());

        }
    }

}

class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小，年龄从小到大
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int compare = -this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        }
        throw new RuntimeException("类型不匹配");
    }
}
