package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * JAVA ★反射机制
 * 反射时Java的动态机制,它允许我们在程序[运行期间]再确定要实例化的对象,调用的方法或操作
 * 的属性。该机制可以大大的提高代码的灵活度和可扩展性，但是也随之带来了较低的运行效率和更多
 * 的系统开销。因此程序不应当过度利用反射机制。
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
      /*
            反射机制第一步，获取要操作的类的类对象
            Class类的实例。该实例用于表示JVM中加载的一个类。
            当JVM加载一个类时就会实例化一个Class对象与之对应，并且每个被加载的类有
            且仅有一个Class的实例与之绑定。
            ★通过该Class实例我们可以了解到其表示的类
            的一切信息(类名，多少个方法，多少个构造器，多少个属性等。)
            获取一个类对象的方式:
            1:类名.class
            Class cls = String.class;
            Class cls = int.class;注:基本类型获取类对象只有上述方式。

            2:Class.forName(String className)---传递一个类的完全限定名(包名+类名)
            基于类的完全限定名(包名.类名)加载一个类----★返回一个类对象
            Class cls = Class.forName("java.lang.String");//需向外抛异常

            3:ClassLoader类加载器形式
         */

//        Class cls = String.class;//获取String的类对象
//        Class cls = Class.forName("java.lang.String");---java.lang(包)String(类)
        /*
            测试类:
            java.util.ArrayList
            java.util.HashMap
            java.io.FileInputStream---该类中没有无参构造器
            java.lang.String
            reflect.Person
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名：");//包名java.lang+类名String
        String className = scanner.nextLine();
        Class cls = Class.forName(className);//加载该类,用Class实例来接收
        System.out.println(cls);//class java.lang.String

        //获取类对象表示的类的完全限定名getName()
        String name = cls.getName();//通过cls引用打点获取类完全限定名
        System.out.println("类对象的完全限定名："+name);//java.lang.String

        //仅获取类名getSimpleName()
        name = cls.getSimpleName();
        System.out.println("类名："+name);//String

        /**
         * package类的实例用于表示一个包的信息
         */
//        用Package类的实例来接收getPackage()方法获取的包信息
//        Package pack = cls.getPackage();
//        System.out.println(pack);//package java.lang, Java Platform API Specification, version 1.8
//        String pname = pack.getName();//获取包名
        String pname = cls.getPackage().getName();//连写获取包名
        System.out.println("包名："+pname);//java.lang
         /*
            Method类的实例用于表示某个类上的一个方法
            通过方法对象可以得知该方法的一切信息(访问修饰符，返回值类型，方法名，参数列表等等)
            还可以通过方法对象来调用该方法(反射重点知识)
         */
        //Class上的getMethods方法可以获取类对象所表示的类所有公开方法(包含从超类继承的)
        Method[] methods = cls.getMethods();
        System.out.println("所有方法如下：");
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }
}
