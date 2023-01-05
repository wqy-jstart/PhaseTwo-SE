package jdk8;

/**
 * 演示JDK1.8新特性--Lambda表达式
 *
 * @Author java@Wqy
 * @Version 0.0.1
 * @since 2023.1.5
 */
public class Lambda01 {
    public static void main(String args[]) {
        Lambda01 tester = new Lambda01();

        // 接口中方法的定义方式
        // 1.类型声明
        MathOperation addition = (int a, int b) -> a + b; // Integer::sum;

        // 2.不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 3.大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 4.没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 用Lambda表达式返回输出语句
        // 1.不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 2.用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    /**
     * 该方法用来返回接口中实现的返回结果
     *
     * @param a             变量a
     * @param b             变量b
     * @param mathOperation 接口MathOperation
     * @return 返回接口中实现后的返回值
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
