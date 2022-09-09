package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 利用反射机制调用Person类中所有无参方法
 * 1:加载Person的类对象
 * 2:实例化Person
 * 3:通过类对象获取所有无参方法
 *   提示:Method上定义了:int getParameterCount()
 *   该方法的作用是获取当前Method表示的方法中有多少个参数
 * 4:执行invoke来调用这个方法
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");//加载Person的类对象
        Object obj = cls.newInstance();//实例化该类对象
        Method[] methods = cls.getDeclaredMethods();//获取所有被类定义的方法(包括私有)
        for (Method method : methods){//遍历所有公开方法
            //int  getParameterCount()该方法用来返回方法参数的个数
            if (method.getParameterCount()==0 &&
                method.getModifiers()== Modifier.PUBLIC//返回公开方法
//                method.getModifiers()==Modifier.PRIVATE//返回私有方法
//                method.getModifiers()==Modifier.PROTECTED//返回受保护的方法
            ){
                System.out.println("调用方法："+method.getName()+"()");
//                method.setAccessible(true);//访问私有方法时再使用此方法
                method.invoke(obj);
            }
        }
        System.out.println("=============================================");
        //获取该类中含有"e"的方法
        Method[] methods1 = cls.getDeclaredMethods();
        for (Method method : methods1){
            if (method.getName().contains("e")){
                System.out.println("含有字母e的方法："+method.getName()+"()");
            }
        }
    }
}
