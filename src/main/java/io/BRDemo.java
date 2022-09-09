package io;

import java.io.*;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流，内部维护一个8192长度的char数组，可以块读文本数据加速
 * 1:自带缓冲
 * 2:可以按行读取字符串,★为null时读到末尾
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;//接收返回每次读取的内容
        /*
            BufferedReader提供的方法:
            String readLine()
            读取并返回一行字符串，返回的字符串中不含有该行结束的换行符。
            如果返回值为null则表示流读取到了末尾
            如果读取了空行(只有一个换行符)返回值为空字符串:""
         */
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) !=null){
            System.out.println(line);
        }
        long end = System.currentTimeMillis();
        System.out.println("读取完毕！耗时："+(end-start)+"ms");
        br.close();//关闭缓冲字符输入流
    }
}
