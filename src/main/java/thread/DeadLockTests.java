package thread;

/**
 * 死锁的案例演示
 */
class SyncTask implements  Runnable{
    // 定义两个对象
    private Object lock1;
    private Object lock2;

    // 构造方法
    public SyncTask(Object lock1,Object lock2){
        this.lock1=lock1;
        this.lock2=lock2;
    }

    // 重写run()方法,当线程开启时自动调用该方法
    @Override
    public void run() {
        synchronized (lock1){
            doWork();
            synchronized (lock2){
                doWork();
            }
        }
    }

    // SyncTask类的成员方法,负责每隔3秒输出语句
    void doWork(){
        System.out.println("execute task");
        try {
            Thread.sleep(3000);
        }catch (Exception e){}
    }
}

public class DeadLockTests {
    // main方法测试
    public static void main(String[] args) {
        // 实例化两个对象
        Object lock1=new Object();
        Object lock2=new Object();
        // 创建两个不同的线程,传入SyncTask对象并传入构造形参开启线程
        Thread t1 = new Thread(new SyncTask(lock1, lock2));
        Thread t2 = new Thread(new SyncTask(lock2, lock1));
        t1.start();
        t2.start();
    }
}