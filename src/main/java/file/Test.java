package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取./src/main/java/file下所有名字以D开头的★子项
 * 用到过滤器:FileFilter接口中的boolean accept(File pathname)方法
 */
public class Test {
    public static void main(String[] args) {
        File dir = new File("./src/main/java/file");
        if(dir.isDirectory()){
            FileFilter filter = new FileFilter() {
                @Override
          //★重写FileFilter接口中的accept()方法---------实现不同的过滤方式
                public boolean accept(File file) {
                    String name = file.getName();//获取经过过滤器元素的名字
                    //return name.indexOf("D")==0;
                    return name.startsWith("D");

                    //获取900字节一下的所有文件
                    //long len = file.length();
                    //return len<=900;
                }
            };
            File[] subs = dir.listFiles(filter);//回调模式
            for (File sub : subs){
                System.out.println(sub.getName());
            }
        }


    }
}
