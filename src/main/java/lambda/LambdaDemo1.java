package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * JDK8之后推出了一个特性：lambda表达式
 * lambda表达式可以用更精简的语法创建匿名内部类
 * 语法：
 * (参数列表)->{
 *       方法体
 *  }
 *  需要注意:只有被实现的接口中含有一个抽象方法时，才可以使用lambda表达式创建。
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //定义一个文件过滤器,过滤规则为名字中含有字母"F"
        //文件过滤器的匿名内部类创建形式
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().contains("F");
            }
        };
//省去了接口名和方法名部分,参数类型也可以不写(源码中只有一种方法类型)
        FileFilter filter1 = (File file)-> {
                return file.getName().contains("F");
            };
//如果方法体只有一句代码，那么方法体"{}"可以忽略，如果这句代码含有return要一同忽略
        FileFilter filter2 = (file)->file.getName().contains("F");
//如果只有一个参数，那么参数列表的"()"可以忽略不写
        FileFilter filter3 = file->file.getName().contains("F");

        //实际应用：
        File dir = new File("./src/main/java/file");
        //定义一个文件数组,传入一个过滤器,过滤指定文件
//        File[] subs = dir.listFiles(new FileFilter() {
//            public boolean accept(File file) {
//                return file.getName().contains("F");
//            }
//        });
        File[] subs = dir.listFiles(f->f.getName().contains("F"));

    }
}
