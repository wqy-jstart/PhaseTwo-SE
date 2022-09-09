package thread;

/**
 * 多线程
 * 线程：一个单一的顺序执行流程就是一个线程
 * 多线程：多个顺序执行流程"同时"执行
 *
 * 1：继承Thread
 * 2:重写run方法定义线程执行的任务代码
 * 3:调用线程的start方法将线程启动
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread1();//新建状态
        Thread t2 = new MyThread2();
        t.start();//就绪状态,等待JVM中线程调度器的调度
        t2.start();
        //当获取到CPU资源时就可以执行run(),随着进入运行状态

    }
}

/**
 * 第一种创建线程的优点:结构简单，利于匿名内部类形式创建
 * 缺点:
 * 1:由于java是单继承的，这导致如果继承了线程就无法再继承其他类去复用方法
 * 2:创建线程的同时重写run方法将任务定义在线程中，这导致线程与任务存在必然的耦合关系
 *   不利于线程的重(chong)用。
 */
class MyThread1 extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是谁呀！"+i);
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("查水表的！"+i);
        }
    }
}
