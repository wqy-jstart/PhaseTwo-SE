package unicode;

import java.nio.charset.StandardCharsets;

// 关于Unicode的解析案例
public class UnicodeDemo01 {
    public static void main(String[] args) {
        String str = "测试: \u0d15\u0DF4\u0DC9\u26C4";
        System.out.println("源字符串:"+str);// 经编译:测试: ക෴෉⛄

        String s = "A";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("A三个大写英文的字节长度为:"+bytes.length);// 1

        s = "\u058d";
        System.out.println("源字符串:"+s);// ֍
        bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("字节长度为:"+bytes.length);// 2

        s = "\u097A";
        System.out.println("源字符串:"+s);// ॺ
        bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("字节长度为:"+bytes.length);// 3

        s = "武";
        System.out.println("源字符串:"+s);// 武
        bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("字节长度为:"+bytes.length);// 3

        char a = '清';
        System.out.println("'清'字对应的码为:"+(int)a);

    }
}
