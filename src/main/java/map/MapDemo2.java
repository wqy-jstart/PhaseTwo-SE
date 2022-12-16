package map;

import java.util.*;

/**
 * ★ Map的遍历
 * Map支持三种遍历方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对
 * 3:遍历所有的value(相对不常用)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",98);
        map.put("数学",97);
        map.put("英语",96);
        map.put("物理",95);
        map.put("化学",98);
        /*1:
         Set keySet()
         将当前Map中所有的key值(不能重复)以一个Set集合(★不允许重复的集合)形式返回
         */
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            System.out.println("key:"+key);
        }
        System.out.println("=========================================");

        /*2:
         Set entrySet()
         返回一个Set集合,集合中每一个元素是一个Entry实例。
         ★ Map.Entry的每一个实例表示Map中的一组键值对,有两种常用方法:
         K getKey()    获取这组键值对的key
         V getValue()  获取这组键值对的value
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> e : entrySet){
            String key = e.getKey();//将对应元素存到对应键值中
            Integer value = e.getValue();
            System.out.println(key+":"+value);//拼号输出
            System.out.println(map);//如果遍历后直接输出map
            //{物理=95, 数学=97, 化学=98, 语文=98, 英语=96}中间等号形式输出
        }
        System.out.println("=========================================");

        /*3:
          Collection values()
          将当前Map中所有的value以一个Collection可重复集合的形式返回
         */
        Collection<Integer> values = map.values();
        for (Integer value : values){ //把集合中的每一个元素赋给变量value顺序输出
            System.out.println("value:"+value);
        }
        System.out.println("=========================================");

        //Collection集合
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        for (String e : c){//将集合中的元素c赋值给String变量e,顺序输出
            System.out.println(e);
        }
        System.out.println("==============================================");

        //利用迭代器遍历
        Iterator it = c.iterator();
        while (it.hasNext()) {
            String str = (String)it.next();
            System.out.println(str);
        }
        System.out.println("===============================================");

        //Collection集合的forEach方式遍历：
        c.forEach(
                e-> System.out.println(e)
        );

        //Map也支持forEach方法
        map.forEach(
                (k,v)-> System.out.println(k+":"+v)
        );

        // ::写法
        c.forEach(System.out::println);
    }
}
