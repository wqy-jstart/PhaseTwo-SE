package reflect;

import java.lang.reflect.Method;

/**
 * 利用反射机制调用Person类中所有无参构造方法
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");//加载Person的类对象
        Object obj = cls.newInstance();//实例化该类对象
        Method[] methods = cls.getDeclaredMethods();//获取所有被类定义的方法(包括私有)
        for (Method method : methods){//遍历所有公开方法
            //int  getParameterCount()该方法用来返回方法参数的个数
            if (method.getParameterCount()==0){
                System.out.println("调用方法："+method.getName()+"()");
                method.setAccessible(true);
                method.invoke(obj);
            }
        }
    }
}
