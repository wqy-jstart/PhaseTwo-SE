package reflect;

import java.lang.reflect.Method;

/**
 * 调用有参方法(第一个填方法名其余填参数类名)
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        //正常调用有参方法
        Person p = new Person();
        p.say("大家好！");
        p.say("我真的栓Q",5);

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();//相当于实例化对象Person p = new Person();
        //say(String)
        Method method = cls.getMethod("say",String.class);//第一个填方法名其余填参数类名
        method.invoke(obj,"大家好！");//第一个传对象名其余填参数
        //say(String,int)
        Method method1 = cls.getMethod("say",String.class,int.class);
        method1.invoke(obj,"我真的栓Q",10);
    }
}
