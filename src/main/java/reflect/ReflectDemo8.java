package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

/**
 * 通过注解对象获取参数value的值
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");//加载该类
        Method method = cls.getDeclaredMethod("sayHello");//获取类中sayHello()方法
        if (method.isAnnotationPresent(AutoRunMethod.class)){//如果该方法被标注
            //获取该方法对象所表示的方法上的特定注解
            //getAnnotation()方法利用注解类来接收
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
            //通过注解对象获取参数value的值
            int value = arm.value();
            System.out.println("参数："+value);
        }
    }
}
