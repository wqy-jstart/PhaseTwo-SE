package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 所有的输出流才会有flush()方法
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "super idol的笑容,都没你的甜.";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
        /*
            flush方法是接口Flushable中定义的唯一的抽象方法.
            而输出流的超类:java.io.OutputStream实现了该接口,这意味着所有的输出流
            都有这个方法.
            求他高级流的flush方法实现就是调用其连接的流的flush,目的是将flush动作传递
            下去直到调用到了缓冲输出流的flush才会真实清空缓冲区写出.
         */
        bos.flush();//当缓冲区未满8k时,强制输出(写不写分情况)
        System.out.println("写出完毕！");
        bos.close();//取消缓冲输出流,内部有一个flush()方法
    }
}
