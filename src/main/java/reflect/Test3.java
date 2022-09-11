package reflect;

import reflect.annotations.AutoRunClass;

import java.io.File;

/**
 * 实例化与当前类Test3在同一个包中被@AutoRunClass标注的类
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        File dir = new File( //定位Test3文件加载路径
                Test3.class.getResource(".").toURI()
        );
        System.out.println("Test3文件的加载路径为："+dir);
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));//利用过滤器保留含.class的文件
        for (File sub : subs){ //遍历保留的文件名
            String fileName = sub.getName();//获取遍历后的类名
            //截取文件名(下标0到最后一个".")
            String className = fileName.substring(0,fileName.lastIndexOf("."));
            System.out.println("截取后的类名："+className);
            Class cls1 = Test3.class;//传入Test3并且加载Test3类
            String packageName = cls1.getPackage().getName();//获取Test3类所在的包名
            Class cls = Class.forName(packageName+"."+className);//传入类的完全限定名并加载该类
            if (cls.isAnnotationPresent(AutoRunClass.class)){//如果该类被@AutoRunClass标注了
                Object obj = cls.newInstance();//实例化该类
                System.out.println("该类正在进行实例化...");
                System.out.println(obj);//输出对象的引用
            }
        }
    }
}
