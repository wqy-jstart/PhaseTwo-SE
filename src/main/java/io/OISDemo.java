package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * 使用对象输入流完成对象的反序列化操作
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将person.obj文件中的对象反序列化
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
          对象输入流提供了反序列化操作
          Object readObject();
         */
        Person p = (Person)ois.readObject();//调用读对象的方法时返回值为Object类型,故需要强转
//因对象的otherInfo属性使用了transient关键字修饰,使其属性值未保存至文件中,故读取时值为null
        System.out.println(p);
        ois.close();//关闭对象输入流
    }
}
