package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map 查找表  是Java集合框架(Java Collections Framework)的一员
 * Map本身是一个接口,这种结构体现出来是一个多行两列的表格,其中左列称key,右列称value
 * Map总是根据key获取对应的value
 *
 * 常用实现类:java.util.HashMap 散列表,哈希表
 * HashMap是使用散列算法实现的Map,当今查询速度最快的数据结构
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map);//{}
        /*
            V put(K k,V v)
            将一组键值对存入Map中。
            Map有一个特点:Key不允许重复！！！(key的equals决定是否为重复的key)
            如果使用重复的key来put元素，则是替换value操作。此时方法返回值为被替换的value
            否则为null.
         */
        //如果Map的value是一个包装类类型,获取时不要用基本类型接收避免因为自动拆箱导致空指针
        //int value = map.put("语文",98).intValue();
        Integer value = map.put("语文",98);
        System.out.println(value);//被替换的值null
        map.put("语文",98);
        map.put("数学",97);
        map.put("英语",96);
        map.put("物理",95);
        map.put("化学",98);
        System.out.println(map);//{物理=95, 数学=97, 化学=98, 语文=98, 英语=96}
        value = map.put("语文",55);//替换value
        System.out.println(map);//{物理=95, 数学=97, 化学=98, 语文=55, 英语=96}
        System.out.println(value);//替换的value值98
        /*
          int size()
          返回当前Map中键值对的个数
         */
        int size = map.size();
        System.out.println("size:"+size);//size:5
        /*
           V get(Object key)
           根据给定的key获取对应的value,如果给定的key在Map中不存在则返回值为null
         */
        value = map.get("英语");
        System.out.println("英语："+value);//96
        value = map.get("体育");
        System.out.println("体育："+value);//null
         /*
            V remove(K k)
            根据给定的key删除Map中这组键值对。返回值为这个key对应的value。
         */
        value = map.remove("语文");
        System.out.println(map);//{物理=95, 数学=97, 化学=98, 英语=96}
        System.out.println(value);//55
        /*
            boolean containsKey(Object key)
            判断当前Map是否包含给定的key
            boolean containsValue(Object value)
            判断当前Map是否包含给定的value
            这里判断包含是依靠equals方法判断的。
         */
        boolean ck =map.containsKey("物理");
        boolean ck1 = map.containsKey("体育");
        System.out.println(ck1);//false
        boolean cv =map.containsValue(97);
        System.out.println("包含key:"+ck);//包含key:true
        System.out.println("包含value:"+cv);//包含value:true

        map.clear();//清除Map中所有键值对
        System.out.println(map);//{}
    }
}

