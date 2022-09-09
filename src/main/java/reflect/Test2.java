package reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 实例化与当前类Test2在同一个包中的所有类
 * 思路:
 * 1:首先定位Test2的字节码文件所在的目录(main方法里第一行代码)
 * 2:通过该目录获取里面所有的.class文件
 * 3:由于字节码文件名与类名一致(JAVA语法要求)，因此可以通过文件名确定类名
 * 4:使用Class.forName()加载对应的类并实例化
 *
 * 上述完成后，自动调用这些类中所有的无参且公开的方法(本类定义的方法)。
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        File dir = new File( //定位Test2所在的文件加载路径
                Test2.class.getResource(".").toURI()
        );
        System.out.println(dir);
        //添加过滤器获取该目录中的所有字节码文件
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for (File sub : subs){
            String fileName = sub.getName();//获取过滤后的文件名
            //截取0到"."的部分
            String className = fileName.substring(0,fileName.lastIndexOf("."));
//            String className = fileName.replace(".class","");
            System.out.println("截取后的类名："+className);//输出截取后的文件名
            Class cls1 = Test2.class;//加载该类
            String packName = cls1.getPackage().getName();//获取该类所在的包名
            Class cls = Class.forName(packName+"."+className);//拼接成完全限定名
            System.out.println("正在实例化："+cls.getName());
            Object obj = cls.newInstance();//实例化该类
            Method[] methods = cls.getDeclaredMethods();//获取包括私有在内的所有方法
            for (Method method : methods){
                if (method.getParameterCount()==0 &&
                    method.getModifiers()== Modifier.PUBLIC
                ){
                    System.out.println("调用方法："+method.getName()+"()");
                    method.invoke(obj);//执行该类中符合条件的方法
                }
            }
        }
    }
}
