package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计字符串中每个字符出现的次数
 * 思路:
 * 用一个Map保存统计结果，key保存出现的字符，value保存该字符出现的次数
 * 利用字符串的charAt方法可以遍历字符串中每一个字符
 * 如果map中该字符不存在，则存入，并且对应的次数为1
 * 如果map中该字符已经存在，则根据该字符作为key提取其value(出现的次数)并对value+1再
 * 存回。
 * 遍历后输出map即可得知每个字符出现的次数。
 */
public class Test {
    public static void main(String[] args) {
        String line = "Thinking in java! i love java!";
        Map<Character,Integer> map = new HashMap<>();//定义一个Map
        for (int i = 0; i < line.length(); i++) {//遍历字符串中的每个字符元素
//            三目运算:
//            char c = line.charAt(i);
//            int num = map.containsKey(c)?map.get(c)+1:1;
//            map.put(c,num);
            char c = line.charAt(i);//将遍历的元素赋值给字符类型c
            System.out.println(c);//顺序输出c
            if (map.containsKey(c)){//判断如果map中包含字符c
                int sum = map.get(c);//将获取字符c的value值赋给整型变量sum
                sum = sum+1;//sum增1
                map.put(c,sum);//将两个键值存入map中
            }else {
                map.put(c,1);//如果不包含则为1
            }
        }
        System.out.println(map);
    }
}
