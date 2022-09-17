/**
 * 测试创建对象时调用构造方法的规律
 */
//当创建对象的时候会自动调用构造方法,一定是先执行超类的静态块再执行派生类的，
//然后走new的对象的构造方法,若new的派生类或向上造型,
//则默认先走超类构造方法ABab;若new的超类,则只走超类的静态块和构造方法Aa
public class CreateFunctionDemo {
    public static void main(String[] args) {
//        A a = new A();//A a
//        A b = new B();//A B a b
        B c = new B();//A B a b
    }
}
class A{
    static {
        System.out.println("A");
    }
    A(){
        System.out.println("a");
    }
}
class B extends A{
    static {
        System.out.println("B");
    }
    B(){
        System.out.println("b");
    }
}
