package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 用文件输入流读取文本中字符串,★以文件总大小为单位
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java/io/ReadStringDemo.java");
        FileInputStream fis = new FileInputStream(file);
        long len = file.length();//获取文件大小(字节量)
        byte[] data = new byte[(int)len]; //创建一个字节数组，长度为文件大小
        fis.read(data);//一次性将文件大小的字节量写入data中
        //String的构造方法可以将一个字节数组中所有字节按照给定的字符集还原为字符串
        String line = new String(data, StandardCharsets.UTF_8);//获取字符集
        System.out.println(line);//在控制台输出字符串line的内容
        fis.close();//关闭输入流
    }
}
