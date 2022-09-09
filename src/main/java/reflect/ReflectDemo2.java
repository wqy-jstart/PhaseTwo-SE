package reflect;

import java.util.Scanner;

/**
 * 使用反射机制实例化对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //如果不重写toString()方法则两种方法输出的对象不同
        Person p = new Person();
        System.out.println(p);//reflect.Person@1b6d3586

        //1)加载需要实例化对象的类的类对象
//        Class cls = Class.forName("reflect.Person");
        /*
          日期类,该类的每一个实例用于表示一个具体的时间点,默认创建表示当前系统时间
          java.util.Date
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);//传入类名,返回一个类对象

        //2)类对象提供了方法newInstance()可以利用其表示类的公开的无参构造器实例化
        Object obj = cls.newInstance();//newInstance()该方法返回值为Object类型
        System.out.println(obj);//reflect.Person@4554617c
    }
}
