package thread;
/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源由于线程切换时机不确定，导致执行顺序出现混乱从而导致不良后果
 * 临界资源:操作该资源的完成过程同一时刻只能被单一线程进行的。
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        //创建两个线程,执行一个方法任务
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();//从桌子上拿一个豆子
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
class Table{
    private int beans = 20;//桌子上有20个豆子
    //synchronized关键字防止两个线程同时执行一个方法
    public synchronized int getBeans(){
        if (beans == 0){
            throw new RuntimeException("没有豆子了！");
        }
        //主动放弃本次时间片用来模拟线程执行到这里时CPU时间片用完了
        Thread.yield();//该方法可以让运行该方法的线程主动放弃本次剩余时间片
        return beans--;
    }
}
