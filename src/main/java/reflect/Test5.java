package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
/**
 *  自动调用与当前类Test4在同一个包中被注解@AutoRunClass标注的类中那些被@AutoRunMethod
 *  标注的方法指定次(次数有注解@AutoRunMethod的参数指定)。
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        File dir = new File( //定位Test4文件加载路径
                Test5.class.getResource(".").toURI()
        );
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));//过滤文件
        for (File sub : subs){//遍历过滤后的文件
            String fileName = sub.getName();//获取过滤后文件的名字赋给fileName
            //截取0到最后一个"."的部分
            String className = fileName.substring(0,fileName.lastIndexOf("."));
            Class cls1 = Test5.class;//加载Test5类
            String packageName = cls1.getPackage().getName();//利用加载Test5类的引用来获取包名
            Class cls = Class.forName(packageName+"."+className);//加载类并传入完全限定名
            if (cls.isAnnotationPresent(AutoRunClass.class)){//如果该类被@AutoRunClass标注
                System.out.println("实例化:"+className);
                Object obj = cls.newInstance();//实例化该类
                Method[] methods = cls.getDeclaredMethods();//利用加载该类的引用获取类中的所有方法(包括私有)
                for (Method method : methods){//遍历方法数组
                   if (method.isAnnotationPresent(AutoRunMethod.class)){//如果该方法被@AutoRunMethod标注
                       //获取该方法对象所表示的方法上的特定注解
                       //getAnnotation()方法利用注解类来接收
                       AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                       //通过注解对象获取参数value的值
                       int value = arm.value();
                       String methodName = method.getName();
                       System.out.println("开始调用方法:"+methodName+"()共"+value+"次");
                       for (int i = 0; i < value; i++) {
                           method.invoke(obj);
                       }
                   }
                }
            }
        }
    }
}
