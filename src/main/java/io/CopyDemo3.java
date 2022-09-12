package io;

import java.io.*;

/**
 * java将流分为两类:节点流与处理流
 * 节点流(也称为低级流):特点是实际连接程序与另一端的"管道",负责实际读写数据的流.
 * 处理流(也称为高级流):特点是不能独立存在,必须连接在其他流上,目的是当数据经过当前流时
 *                   对该数据进行某种加工操作,简化我们的同等工作.
 *
 * 文件流就是一对典型的低级流,因为它是实际连接程序与文件之间的"管道",负责实际读写文件数据的流
 *
 * 实际开发中我们经常会串联一组高级流最终到某个低级流上,使得读写数据的过程中以"流水线"式
 * 的加工完成.这个过程也称为流的连接.
 *
 * 缓冲流:java.io.BufferedInputStream和BufferedOutputStream
 * 功能:加快读写字节数据的效率
 */
//利用缓冲流保证读写速度
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("image_cp3.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //byte[] data = new byte[1024*10];若指定一次读取的字节量
        int d;
        long start = System.currentTimeMillis();
        //缓冲流内部默认以8kb为单位进行读写操作,小于8kb先载入缓冲区
        //若载入缓冲区,不添加任何方法的情况下不达到8kb是不读出的
        while ((d = bis.read())!=-1) { //用BufferedInputStream来读
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时："+(end-start)+"ms");

        bis.close();//取消缓冲输入流
        bos.close();//取消缓冲输出流
    }
}
