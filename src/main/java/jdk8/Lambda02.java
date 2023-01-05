package jdk8;

/**
 * 演示Lambda表达式的作用域
 *
 * @author java@Wqy
 * @version 0.0.1
 * @since 2023.1.5
 */
public class Lambda02 {
    // $lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
    final static String salutation = "Hello! "; // 定义不可变的静态字符串

    public static void main(String args[]) {
        // 定义接口中的方法
        GreetingService greetService1 = message ->
                System.out.println(salutation + message); // 访问外层的final变量
        greetService1.sayMessage("Runoob"); // 调用接口中的方法,空返回！
        // Hello! Runoob
    }

    // 定义一个接口
    interface GreetingService {
        void sayMessage(String message);
    }
}

// 演示在Lambda表达式中访问外层的局部变量
class Java8Tester {
    public static void main(String args[]) {
        final int num = 1;
        // 使用Lambda表达式定义接口中的方法
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3

        // lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        int num1 = 5;
        Converter<Integer,String> s1 = (param) -> System.out.println((param + num1));

        // num1 = 6;// Local variable num defined in an enclosing scope must be final or effectively

    }

    // 定义一个接口并指定两个任意类型的泛型
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
