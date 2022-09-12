package thread;

/**
 * 互斥锁
 * 当使用多个synchronized锁定多个代码片段,并且指定的同步监视器对象是同一个时,那么
 * 这些代码片段直接就是互斥------★多个线程不能同时执行它们
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Boo boo = new Boo();
        //若不加synchronized关键字,则两个线程互不打扰分别执行
        Thread t1 = new Thread("A"){
            @Override
            public void run() {
                boo.methodA();
            }
        };
        Thread t2 = new Thread("B"){
            @Override
            public void run() {
                boo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}

class Boo{
    public synchronized void methodA(){
        try {
            Thread t = Thread.currentThread();//返回一个当前正在执行线程对象的引用
            System.out.println(t.getName()+":正在执行A方法...");
            Thread.sleep(3000);
            System.out.println(t.getName()+":执行A方法完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//   public void methodB(){
//       synchronized (this){-----互斥(相同同步监视器对象)
//       synchronized ("this"){-----不互斥"this"为字面量对象,与该实例的对象不同
    public synchronized void methodB(){
        try {
            Thread t = Thread.currentThread();//返回一个当前正在执行线程对象的引用
            System.out.println(t.getName()+":正在执行B方法...");
            Thread.sleep(3000);
            System.out.println(t.getName()+":执行B方法完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}