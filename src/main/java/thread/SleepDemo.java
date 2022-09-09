package thread;

import java.util.Scanner;
/**
 * sleep阻塞
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法可以让执行这个方法的线程进入阻塞状态(BLOCK状态)指定毫秒，超时后线程会自动回
 * 到RUNNABLE状态再次开始并发执行
 */
public class SleepDemo {
    public static void main(String[] args) {//main方法为main主线程
        System.out.println("程序开始了！");
        /*
         * 做一个简易倒计时程序
         * 要求：程序启动后输入一个数字,从该数字开始每秒递减并输出,当到0时输出时间到
         */
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入时间：");
//            for (int time = scanner.nextInt(); time > 0; time--) {
//                System.out.println(time);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            int time = scanner.nextInt();
            while (true){
                if (time>=0){
                    Thread.sleep(1000);
                    System.out.println(time);
                    time--;
                }else {
                    System.out.println("时间到！");
                    break;
                }
            }
        } catch (InterruptedException e) {//要强行处理中断异常
            e.printStackTrace();
        }
            System.out.println("程序结束了！");
    }
}
