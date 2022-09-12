package thread;

/**
 * 同步块
 * 有效的缩小同步范围可以保证并发安全的前提下尽可能的提高并发效率。
 *
 * 同步语句块：
 * synchronized(同步监视器对象){
 *     需要多个线程同步执行的代码片段(一个线程使用没有意义)
 * }
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
//若创建两个对象,synchronized (this)中的对象不一样,没有并发安全问题,可以同时执行
//       Shop shop2 = new Shop();
        //创建两个线程,执行一个方法任务
        Thread t1 = new Thread("范传奇"){
            @Override
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread("王克晶"){
            @Override
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}
class Shop{
    //synchronized关键字使两个线程顺序执行该方法
    public void buy(){
        /*
            在方法上使用synchronized，那么同步监视器对象就是this。
         */
//    public synchronized void buy(){
        Thread t = Thread.currentThread();//获取运行该方法的线程
        try {
            System.out.println(t.getName()+":正在挑衣服...");
            Thread.sleep(5000);
            /*
              同步块使用时要指定同步监视器对象,该对象的选取要同时满足：
              1：这个对象可以是java中任何引用类型的实例，只要保证多个需要排队
              2：执行该同步块中代码的线程看到的该对象是"同一个"即可
             */
            //synchronized (new Object()){
            //不可以,不满足第二个条件,执行代码的线程不一定看到的是同一个锁对象

            //synchronized ("hello"){
             /*
               不是合适的锁对象,因为字符串字面量对象全局唯一,----绝对化
               这会导致多个线程执行不同的shop的buy方法时(没有并发安全问题时)
               也要求同时执行,这会降低效率
             */
            synchronized (this){//根据两个线程指向的对象来判断是否互斥
                System.out.println(t.getName()+":正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(t.getName()+":结账离开！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
