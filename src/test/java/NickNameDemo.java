/**
 * 普通类的匿名内部类重写特点
 */
public class NickNameDemo {
    public void Aoo(){
        System.out.println("12345678");
    }
    public void Boo(){
        System.out.println("87654321");
    }
}
//利用Demo匿名内部类重写Aoo和Boo普通方法时可以选择性重写
class Test{
    public static void main(String[] args) {
        NickNameDemo d = new NickNameDemo(){
            @Override
            public void Aoo() {
                System.out.println("1234");
            }

            @Override
            public void Boo() {
                System.out.println("abcde");
            }
        };
        d.Aoo();
        d.Boo();
    }
}
