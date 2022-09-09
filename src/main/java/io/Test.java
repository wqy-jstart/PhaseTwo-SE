package io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 实现简易记事本
 * 要求：
 * 程序启动后,将用户在控制台上输入的每一行字符串都写入文件note.txt中。
 * 当用户单独输入"exit"时程序退出。
 * 用文件输出流
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //利用文件输出流向note.txt中写入文本内容
        FileOutputStream fos = new FileOutputStream("note.txt");
        Scanner scan = new Scanner(System.in);
        System.out.println("开始输入内容，单独输入exit退出");
        while (true){
            String line = scan.nextLine();
            if("exit".equalsIgnoreCase(line)){//--equalsIgnoreCase()忽略大小写比较
                break;
            }
            fos.write(line.getBytes(StandardCharsets.UTF_8));
            System.out.println("请再次输入内容：");
        }
        fos.close();//关闭文件输出流
    }
}
