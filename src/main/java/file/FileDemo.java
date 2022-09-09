package file;

import java.io.File;

/**
 *java.io.File
 * File用来表示硬盘上的一个文件或目录的(本质是表示一个抽象路径)
 * 使用File可以:
 * 1:访问其表示的文件或目录的属性信息
 * 2:创建和删除文件或目录
 * 3:访问一个目录中的所有子项
 * File不能访问文件数据
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
           创建File时需要指定路径，而路径通常使用相对路径。绝对路径存在跨平台问题。
           相对路径中常见的"./"表示当前目录，在IDEA中执行时"./"的位置时当前项目
           目录
         */
        File file = new File("./demo.txt");//(./)相对该项目的文件
        //1)获取文件长度(单位是字节)
        long len = file.length();
        System.out.println("该文件有："+len+"个字节");
        //2)获取文件名
        String name = file.getName();
        System.out.println("文件名字："+name);
        //3)判断是否可读
        boolean a = file.canRead();
        System.out.println("是否为可读文件？"+a);
        //4)判断是否可写
        boolean b = file.canWrite();
        System.out.println("该文件是否可以修改？"+b);//可在文件属性中勾选只读
        //5)是否隐藏
        boolean ih = file.isHidden();
        System.out.println("是否隐藏？"+ih);
    }
}
