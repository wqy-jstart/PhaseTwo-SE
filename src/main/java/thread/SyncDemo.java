package thread;
/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源由于线程切换时机不确定，
 * 导致执行顺序出现混乱从而导致不良后果，严重时可能导致系统瘫痪。
 * 临界资源:操作该资源的完成过程同一时刻只能被单一线程进行的。
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        //创建两个线程,执行一个方法任务
        //匿名内部类写法(不需要另外再创建一个类来重写接口中的方法)
        Thread t1 = new Thread("李华") {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();//从桌子上拿一个豆子
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread("小明") {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                     /*
                        static void yield()
                        线程提供的这个静态方法作用是让执行该方法的线程
                        主动放弃本次时间片。
                        这里使用它的目的是模拟执行到这里CPU没有时间了，发生
                        线程切换，来看并发安全问题的产生。
                     */
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        //启动两个线程
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
