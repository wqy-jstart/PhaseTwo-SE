package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池是线程的管理类,主要解决两个问题
 * 1：控制线程数量
 * 2：重用线程
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //1)创建一个线程池,参数为线程的个数
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        
        //2)指派任务
        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread();//返回对当前正在执行的线程对象的引用。
                    System.out.println(t.getName()+":正在执行一个任务...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(t.getName()+":执行一个任务完毕!");
                }
            };
            threadPool.execute(runnable);//execute()该方法返回值为void,传入一个线程任务
            //这种情况下线程任务结束后,进程并不停止
            System.out.println("将一个任务交给了线程池");
        }
//        threadPool.shutdown();shutdown()方法等线程任务结束后才结束进程
        threadPool.shutdownNow();//shutdownNow()方法执行后线程再进行会报异常
        System.out.println("线程池停止了！");
    }
}
