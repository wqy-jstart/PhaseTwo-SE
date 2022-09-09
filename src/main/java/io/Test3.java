package io;

import java.io.*;
import java.util.Scanner;
/**
 * 实现简易记事本
 * 要求：
 * 程序启动后,将用户在控制台上输入的每一行字符串都写入文件note.txt中。
 * 当用户单独输入"exit"时程序退出。
 * 用缓冲字符输出流
 */
public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("pw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        //PrintWriter(bw,true);该重载可自动进行行刷新，相当于加上pw.flush;
        PrintWriter pw = new PrintWriter(bw,true);
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入内容,单独输入exit时退出：");
        while (true){
            String line = scan.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }else {
                //println();输出加换行
                //print();输出不换行
                pw.println(line);
            }
        }
        pw.close();//关闭字符输出流
    }
}
