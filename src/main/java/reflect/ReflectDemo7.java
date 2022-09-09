package reflect;

import reflect.annotations.AutoRunClass;

public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");//先加载传入完全限定名的类
        if (cls.isAnnotationPresent(AutoRunClass.class)){ //判断该类是否被@AutoRunClass标注
            System.out.println("被标注了！");
        }else {
            System.out.println("没有被标注！");
        }
    }
}
