package file;

import java.io.File;

/**
 * 访问一个目录中所有的子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        //获取当前项目目录下的所有子项
        File dir = new File(".");//"."为当前项目目录
        /*
           boolean isFile()
           判断当前File对象表示的是否为一个文件
           boolean isDirectory()
           判断当前File对象表示的是否为一个目录
         */
        if(dir.isDirectory()){
            System.out.println(dir.getName()+":是一个目录");
            /*
                File[] listFiles()
                获取当前File对象表示的目录中的所有子项.
                返回的数组中每个File对象就是该目录中的一个子项.
             */
            File[] subs = dir.listFiles();//用File[]数组接收返回的子项
            System.out.println(subs.length+"个子项");//获取子项(元素)的数量
            for (File sub : subs){ //增强for遍历
                System.out.println(sub.getName());//输出遍历后获取的子项
            }
        }
    }
}
