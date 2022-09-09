package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * java将流按照读写单位划分为字节流与字符流
 * java.io.InputStream和OutputStream是所有字节流的超类
 * java.io.Reader和Writer则是所有字符流的超类.
 *
 * 字符流读写以字符(char)为最小单位进行.
 *
 * 转换流
 * java.io.InputStreamReader(转换字符输入流)和OutputStreamWriter(转换字节输出流)
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入文本数据-------转成UTF-8的格式
        FileOutputStream fos = new FileOutputStream("osw.txt");
        /*
            创建转换流时通常要明确字符集(不指定会使用系统默认的,这可能导致跨平台问题)
         */
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        /*
            OutputStreamWriter继承自字符输出流超类Writer
            Writer上提供了直接写出字符的write方法.
            转换输出流OutputStreamWriter是一个高级流,通过它写出的字符会被转换为字节
            再写出.
         */
        osw.write("如果你突然打了个喷嚏,啊,那一定是我在想你.");
        osw.write("如果半夜被手机吵醒,啊,那一定是我关心.");

        System.out.println("写出完毕");
        osw.close();//关闭转换输出字节流(字符->字节)
    }
}
