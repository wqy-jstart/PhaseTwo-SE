package reflect;

import reflect.annotations.AutoRunClass;

/**
 * 判断类是否被标注
 * isAnnotationPresent(AutoRunClass.class)该方法返回boolean类型
 */
public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");//先加载并传入完全限定名的类
        if (cls.isAnnotationPresent(AutoRunClass.class)){ //判断该类是否被@AutoRunClass标注
            System.out.println("被标注了！");
        }else {
            System.out.println("没有被标注！");
        }
    }
}
