package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

/**
 * 使用当前类测试反射机制
 */
@AutoRunClass//在Person类上添加注解
public class Person {
    private String name = "张三";
    private int age = 22;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @AutoRunMethod(5)
    public void sayHello(){
        System.out.println(name+":hello!");
    }

    public void sayHi(){
        System.out.println(name+":hi!");
    }
    @AutoRunMethod()//@AutoRunMethod()那么value采取默认值
    public void dance(){
        System.out.println(name+"正在跳舞");
    }
    @AutoRunMethod()//@AutoRunMethod()那么value依然采取默认值
    public void sing(){
        System.out.println(name+"正在唱歌");
    }

    public void watchTV(){
        System.out.println(name+"正在看电视");
    }

    public void playGame(){
        System.out.println(name+"正在打游戏");
    }

    public void say(String info){
        System.out.println(name+"说:"+info);
    }

    private void hehe(){
        System.out.println("我是Person类的私有方法！");
    }

    public void say(String info,int count){
        for(int i=0;i<count;i++){
            System.out.println(name+"说:"+info);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
