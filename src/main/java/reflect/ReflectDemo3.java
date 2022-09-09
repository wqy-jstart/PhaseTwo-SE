package reflect;

import java.lang.reflect.Constructor;

/**
 * 使用指定构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        //通过类对象获取其表示的类的某个指定的构造器
//         cls.getConstructor();//Person()-----无参
        /*
          Constructor类的每一个实例用于标识某个类上的某一个构造器
        */
        Constructor c = cls.getConstructor(String.class,int.class);//Person(String,int)----有参
        System.out.println(c);//public reflect.Person(java.lang.String,int)
        Object o = c.newInstance("苍桑",55);//用Object类型接收等同于实例化new Person("苍桑",55);
        System.out.println(o);//Person{name='苍桑', age=55}
    }
}
