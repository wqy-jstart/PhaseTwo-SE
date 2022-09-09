package thread;

public class Demo {
    public void Aoo(){
        System.out.println("123445554");
        }
    public void Boo(){
        System.out.println("23241412414");
        }
}
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