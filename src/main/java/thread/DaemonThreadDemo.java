package thread;
/**
 * 守护线程
 * 守护线程是通过线程的方法setDaemon(boolean on)传入参数true将一个普通线程设置而转变
 * 的。
 * 守护线程有一点是与普通线程不同的，就是进程的结束。
 * ★当java进程中所有的普通线程(包括主线程)都结束时,java进程就会结束,此时会杀死所有还在运行的守护线程
 *
 * 守护线程适合运行那些我们不关心结束时机的任务,只有主要任务都执行完毕它们可以跟着停下来时,
 * 这些任务就可以跑在守护线程上。最有代表性的就是GC,它就是跑在一个守护线程上的.
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {//main方法为main主线程(普通线程)
        Thread rose = new Thread(){//创建一个线程,进入新建状态,等待引用调用start()方法
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("cose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("rose:啊啊啊啊啊啊AAAAAAAaaaaaaa.....");
                System.out.println("扑通");
            }
        };
        Thread jack = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("jack:you jump!I jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        rose.start();//调用start()方法后rose线程进入就绪状态,等待JVM线程调度器的调度
        jack.setDaemon(true);//在jack调用start()方法之前调用,之后转变为守护线程(特点如上)
        jack.start();
//        while (true);//rose线程结束后如果主线程不结束,进程也不会结束,那么jack就不会被进程杀死
    }
}
