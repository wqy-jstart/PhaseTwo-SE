package thread;
/**
 * 线程的优先级
 * 线程有10个优先级分别用整数1-10表示。其中1是最低，10是最高，5是默认值。
 * 当一个线程调用start后便纳入到了线程调度器中被统一管理。线程只能被动的被分配时间片得以
 * 并发运行，不能主动索取时间片。通过调整线程的优先级可以最大程度的改变获取时间片的概率。
 * 在同一个CPU核心中并发执行的线程中优先级越高的线程获取时间片的次数越多。
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread("李华"){//可传递字符串
            @Override//重写
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println(getName()+"：min");
                }
            }
        };

        Thread norm = new Thread(){
            @Override//重写
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("norm");
                }
            }
        };

        Thread max = new Thread(){
            @Override//重写
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("max");
                }
            }
        };
        //Thread.MIN_PRIORITY返回int值
        //setPriority()返回为void,设置优先级,里面返回一个优先级最大值
        min.setPriority(Thread.MIN_PRIORITY);//最高优先级10
        max.setPriority(Thread.MAX_PRIORITY);//最低优先级1
        //norm优先级为默认值5
        min.start();
        norm.start();
        max.start();
    }
}
