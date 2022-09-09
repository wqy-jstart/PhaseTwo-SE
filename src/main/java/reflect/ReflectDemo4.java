package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 使用反射机制调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception{
        //普通调用
        Person p = new Person();
        p.dance();

        //使用反射机制
        //1)实例化
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();//相当于实例化Person obj = new Person();
        //2)调用方法
        //2.1通过类对象获取要调用方法的方法对象(Method对象)
        Method method = cls.getMethod("dance");//获取dance方法对象
        //2.2通过方法对象来调用该方法
        method.invoke(obj);//等同于调用p.dance();

        //测试代码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要实例化的类的类名：");
        String className = scanner.nextLine();//reflect.Student
        System.out.println("请输入要调用的方法名：");
        String methodName = scanner.nextLine();//study

        Class cls1 = Class.forName(className);
        Object obj1 = cls1.newInstance();//相当于Student stu = new Student();
        //2)调用方法
        //2.1)通过类对象获取要调用方法的方法对象(Method对象)
        Method method1 = cls1.getMethod(methodName);
        //2.2)通过方法对象来调用该方法
        method1.invoke(obj1);//相当于stu.study();
        //例：学生:good good study!day day up!
    }
}
