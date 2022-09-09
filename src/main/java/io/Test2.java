package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 实现简易记事本
 * 要求：
 * 程序启动后,将用户在控制台上输入的每一行字符串都写入文件note.txt中。
 * 当用户单独输入"exit"时程序退出。
 * 用转换输出流
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        //利用转换字符流向文件中osw.txt写入文本内容
        FileOutputStream fos = new FileOutputStream("osw.txt");//文件输出流
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);//转换字符流
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入内容：");
        String line1 = scan.nextLine();
        while (true){
            if("exit".equalsIgnoreCase(line1)){
                break;
            }else {
                osw.write(line1);
                System.out.println("请再次输入内容：");
                line1 = scan.nextLine();
            }
        }
        osw.close();//关闭转换字符流
    }
}
