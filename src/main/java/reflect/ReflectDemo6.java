package reflect;

import java.lang.reflect.Method;

/**
 * 获取和访问方法
 */
public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
//        Person p = new Person();
//        p.hehe();
        Class cls = Class.forName("reflect.Person");//加载Person的类对象
        Object obj = cls.newInstance();//实例化类对象
        /* ★
           getMethod()和getMethods()可以获取本类所有公开方法
           getDeclaredMethod()和getDeclaredMethods()可以获取被类定义的方法(包含私有方法)
         */
//        Method method = cls.getMethod("hehe");
        Method method = cls.getDeclaredMethod("hehe");
        //setAccessible()该方法可强行打开访问权限,传true或false打开或关闭
        method.setAccessible(true);//强行打开访问权限
        method.invoke(obj);
        method.setAccessible(false);//用后应当及时关闭访问权限
    }
}
