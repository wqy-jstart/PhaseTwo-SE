package thread;

public class Demo {
    public void Aoo(){
        System.out.println("123445554");
        }
    public void Boo(){
        System.out.println("23241412414");
        }
}
//利用Demo匿名内部类重写Aoo和Boo普通方法时可以选择性重写
class Demo1{
    public static void main(String[] args) {
        Demo d = new Demo(){
            @Override
            public void Aoo() {
                System.out.println("1234");
            }

            @Override
            public void Boo() {
                System.out.println("abcde");
            }
        };
    }
}