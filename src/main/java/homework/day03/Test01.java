package homework.day03;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * 设计一个类:User
 * 里面有四个属性:String name,String pwd,String nick,int age
 * 定义get,set方法以及toString方法和构造方法
 * 
 * 单词记一记:
 * pwd   是单词password的缩写，是密码的意思
 * user  用户
 * 
 * 
 * 当前程序启动后要求用户顺序输入以上四个信息
 * 然后实例化一个User对象保存着四个信息并将
 * 该对象序列化到文件中。
 * 文件名的命名规则:用户名.obj
 * 比如该用户输入用户名为张三，那么这个对象
 * 序列化后的文件名为:张三.obj
 * 
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);//创建一个扫描仪
        //输入并接受用户的各种信息
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        System.out.println("请输入昵称：");
        String nick = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        User user = new User(name,pwd,nick,age);//创建一个User对象,传入各种信息参数
        //创建文件输出流,将路径设置并拼为name+".obj"
        FileOutputStream fos = new FileOutputStream(name+".obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);//创建对象输出流,连接文件输入流
        oos.writeObject(user);//利用对象输出流的引用调用写对象的方法,并传入对象
        System.out.println("写出完毕！");
        oos.close();//关闭对象输出流
    }
}

