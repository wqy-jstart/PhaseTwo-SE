package lambda;

import java.util.*;

/**
 * 集合排序
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i<10; i++) {
            list.add(rand.nextInt(100));
        }
        System.out.println(list);
        //利用比较器自定义从大到小排序
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
         Collections.sort(list,(o1,o2)->o2-o1);
         System.out.println(list);
         list.sort((o1,o2)->o2-o1); // 原本参数列表是一个Comparator比较器，这里使用lambda表达式代替比较器，前者参数列表，后者返回值
        System.out.println(list);
    }
}
