package io;

import java.io.*;
import java.util.Scanner;

/**
 * 使用流,连接完成PW的创建
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            PrintWriter->BufferedWriter->OutputStreamWriter->FileOutputStream
            PW:负责按行写出字符串
            BW:块写文本数据加速(内部有一个默认8192长度的字符数组)
            OSW:将写出的字符转字节
            FOS:将字节写入到文件中
         */
        FileOutputStream fos = new FileOutputStream("pw.txt");//用文件流创建一个文件
        OutputStreamWriter osw = new OutputStreamWriter(fos);//通过转换流将字符转换为字节
        BufferedWriter bw = new BufferedWriter(osw);//缓冲字符输出流，缓冲字符
        //autoFlush--自动行刷新
        PrintWriter pw = new PrintWriter(bw,true);//字符输出流,提供按行写出字符串,★不提供缓冲
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始输入内容,单独输入exit退出");
        while(true) {
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            /*
                当PW开启了自动行刷新后，每当我们调用一次println方法后就会自动flush.
             */
            pw.println(line);
        }
        pw.close();//关闭输出流
    }
}
