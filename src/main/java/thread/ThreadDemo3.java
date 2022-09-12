package thread;

/**
 * 创建线程----匿名内部类写法
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //继承Thread重写run方法----匿名内部类写法
        //利用匿名内部类重写普通类中的方法时,可选择性重写
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("你是谁呀！");
            }
        });

        //实现Runnable接口重写run方法----匿名内部类写法(不需要另外再创建一个类来重写接口中的方法)
        //利用匿名内部类重写接口中的方法时必须全部重写
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("查水表的！");
                }
            }
        };
        Thread t2 = new Thread(r2);
        //Lambda表达式
//        Thread t2 = new Thread( () -> {
//           for (int i = 0; i < 1000; i++) {
//                System.out.println("查水表的！");
//           }
//        });
//        Runnable r2 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println("查水表的！");
//            }
//        };
        //启动线程
        t1.start();
        t2.start();
    }
}
