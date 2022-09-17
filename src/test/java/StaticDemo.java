/**
 * Static静态的练习
 */
public class StaticDemo {
    public static void main(String[] args) {
      Aoo a = new Aoo(25,45);//创建对象,传参
      Aoo.add();//通过类名打点调用静态方法
    }
}
class Aoo{
    static int a;
    static int b;
    Aoo(int c,int d){ //构造方法(有参)----输出结果e
        a=10;
        b=20;
        int e = a+b+c+d;
        System.out.println("结果是："+e);
    }
    //创建一个输出99乘法表的静态方法
    static void add(){
        for (int num = 1; num <=9; num++) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i+"*"+num+"="+(i*num)+"\t");
            }
            System.out.println(" ");
        }
    }
}
