package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个新文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前项目目录下新建一个文件test.txt
        //在相对路径中"./"可以忽略不写的,默认就是从"./"开始
        File file = new File("./a/b/c/d/e/f");
        //★若前面的路径不存在会抛出java.io.IOException: 系统找不到指定的路径。异常
        //例如：File file = new File("./g/test.txt");
        /*
         * boolean exists()方法---返回值为布尔类型
         * 判断该文件是否真实存在,若存在返回true,否则false
         */
        if(file.exists()){
            System.out.println("该文件已存在！");
        }else { //创建文件
            file.createNewFile();//alt+enter(回车) 选第一项add exception....
            System.out.println("文件已创建！");
        }
    }
}
