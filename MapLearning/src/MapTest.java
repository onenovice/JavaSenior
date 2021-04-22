import org.junit.Test;

import java.util.*;

/**
 * @ Description:Map接口常用方法（以HashMap为例）
 * 常用方法（HashMap为例）
 * <p>
 * 增：`put(Object key,Object value)`
 * <p>
 * 删：`remove(Object key)`
 * <p>
 * 改;`put(Object key,Object value)`
 * <p>
 * 查:`get(Object key)`
 * <p>
 * 长度:`size()`
 * <p>
 * 遍历:`keySet(), values(), entrySet()`
 * @ Author: Jay
 * @ Date: Create in 11:05 2021/4/15
 * @ Version:
 */
public class MapTest {
    @Test
    public void MapTest1() {
        Map map = new HashMap();//没要求泛型时，不要求key类型相同
        //put()
        map.put("AA", 1);

        map.put("BB", 2);
        map.put("CC", 1);
        map.put("ab", 21);
        map.put("AA", 110);//如果key存在，则修改
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("DD", 45);
        map1.put("EE", 43);
        //putAll(map)
        map1.putAll(map);
        System.out.println(map1);
        //remove(key),返回删除元素的value
        Object value = map1.remove("DD");
        System.out.println(value);
        //clear()
        map.clear();//map = null,但还在
        System.out.println(map.size());//0
        System.out.println(map);//{}
        //isEmpty()
        System.out.println(map.isEmpty());

        //查询
        //get(key)
        System.out.println(map1.get("AA"));
        System.out.println(map1.get("MM"));//不存在返回：null
        //containsKey(key)
        System.out.println(map1.containsKey("AA"));
        //containsValue(value)
        System.out.println(map1.containsValue(1));
        //size()
        System.out.println("size:" + map1.size());
        //equals()

    }


    //遍历（掌握）
    @Test
    public void MapTest2() {
        Map map = new HashMap();
        map.put("AA", 1);
        map.put("BB", 2);
        map.put("CC", 3);
        map.put("ab", 4);
        //遍历所有key集合：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        //遍历所有的Values
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        //遍历所有key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            //System.out.println(iterator1.next());//直接输出Node
            Object obj = iterator1.next();
            //entrySet集合长得元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-->" + entry.getValue());

        }
        //方式二：分别取
        Set keyset = map.keySet();
        Iterator iterator2 = keyset.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "--->" + value);

        }


    }
}
