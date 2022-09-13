package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 自动调用与当前类Test4在同一个包中被注解@AutoRunClass标注的类中那些被@AutoRunMethod
 * 标注的方法。
 * 注:
 * 反射中的几个反射对象:Class,Method,Constructor,Field等都有isAnnotationPresent
 * 用来判断是否被某个注解标注了
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        File dir = new File( //定位Test4文件加载路径
                Test4.class.getResource(".").toURI()
        );
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));//利用过滤器保留.class的文件
        for (File sub : subs){ //遍历所有过滤后的文件
            String fileName = sub.getName();//将过滤后的文件名赋给字符串fileName
            //截取0到最后一个.部分
            String className = fileName.substring(0,fileName.lastIndexOf("."));
            Class cls1 = Test3.class;//加载Test4类
            String packageName = cls1.getPackage().getName();//利用Test4类的引用获取包名
            Class cls = Class.forName(packageName+"."+className);//加载指定类,传入该类的完全限定名
            if (cls.isAnnotationPresent(AutoRunClass.class)){//如果该类被标注
                Object obj = cls.newInstance();//实例化该类对象
                System.out.println(obj);
                Method[] methods = cls.getDeclaredMethods();//获取该类中的所有(含私有)的方法
                for (Method method : methods){ //遍历获取的方法
                    if (method.isAnnotationPresent(AutoRunMethod.class)){//如果该方法被标注
                        System.out.println("正在调用被标注的方法...");
                        method.invoke(obj);//调用该方法
                    }
                }
            }
        }
    }
}
