package reflect;

import java.io.File;

/**
 * ★实例化与当前类Test2在同一个包中的所有类
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        File dir = new File( //定位Test2所在的目录
                Test2.class.getResource(".").toURI()
        );
        System.out.println(dir);
        //添加过滤器获取该目录中的所有字节码文件
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for (File sub : subs){
            String fileName = sub.getName();//获取过滤后的文件名
            //截取0到"."
            String className = fileName.substring(0,fileName.lastIndexOf("."));
//            String className = fileName.replace(".class","");
            System.out.println("截取后的类名："+className);//输出截取后的文件名
            Class cls1 = Test2.class;//加载该类
            String packName = cls1.getPackage().getName();//获取该类所在的包名
            Class cls = Class.forName(packName+"."+className);//拼接成完全限定名
            System.out.println("正在实例化："+cls.getName());
            Object obj = cls.newInstance();//实例化该类
            System.out.println(obj);//输出该类的引用
        }
    }
}
