package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        //Thread.currentThread()方法可以返回对当前正在执行的线程对象的引用,该线程为主线程
        Thread main = Thread.currentThread();
        System.out.println("主线程是："+main);
        dosome();//主线程执行到这里就调用了dosome方法
    }
    public static void dosome(){//静态方法
        Thread t = Thread.currentThread();//返回对当前正在执行的线程对象的引用
        System.out.println("运行dosome方法的线程是："+t);
    }
}
