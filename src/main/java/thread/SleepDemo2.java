package thread;

/**
 * sleep方法要求我们必须处理中断异常。
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中如果此时该线程的interrupt方法被调用，那么
 * 此时该线程的睡眠阻塞状态会被中断，sleep方法就会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        //建立完对象后处于新建状态,直到启动start()方法
        Thread lin = new Thread("林永健"){
            @Override
            public void run() {
                System.out.println(getName()+":刚美完容,睡一会吧~");
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    System.out.println(getName()+":干嘛呢！干嘛呢！干嘛呢！都破了相了！");
                }
                System.out.println(getName()+":醒了");
            }
        };
        Thread huang = new Thread("黄大锤"){
            @Override
            public void run() {
                System.out.println(getName()+":大锤八十,小锤四十,开始砸墙！");
                for (int i = 0; i < 5; i++) {
                    System.out.println(getName()+":80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("咣当！");
                System.out.println(getName()+":大哥！搞定！");
                lin.interrupt();//中断lin线程的睡眠阻塞
            }
        };
        lin.start();
        huang.start();
    }
}
