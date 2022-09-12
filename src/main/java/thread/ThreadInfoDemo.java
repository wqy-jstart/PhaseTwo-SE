package thread;

/**
 * 获取线程信息的相关方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();//返回对当前正在执行的线程对象的引用。
        String name = main.getName();//获取线程的名字
        System.out.println("名字："+name);//main

        long id = main.getId();//获取唯一标识
        System.out.println("唯一标识："+id);//1

        int priority = main.getPriority();//获取线程优先级
        System.out.println("优先级："+priority);//5

        boolean isAlive = main.isAlive();//是否活着？
        System.out.println("是否活着："+isAlive);//true

        boolean isDaemon = main.isDaemon();//是否为守护线程？
        System.out.println("是否为守护线程："+isDaemon);//false

        Boolean isInterrupted = main.isInterrupted();//是否被中断？
        System.out.println("是否被中断了："+isInterrupted);//false
    }
}
