package file;

import java.io.File;

/**
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //将当前项目目录下的test.txt文件删除
        File file = new File("demo");
        if(file.exists()){ //如果存在
            file.delete(); //delete:删除
            System.out.println("该文件已删除！");//不能乱删,删除后无法找回!!!
        }else {
            System.out.println("该文件不存在！");
        }
    }
}
