package TcpIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 测试查询本机地址
public class Internet01 {
    public static void main(String[] args) {
        try {
            InetAddress ip01 = InetAddress.getByName("127.0.0.1");
            System.out.println(ip01);// /127.0.0.1
            InetAddress ip02 = InetAddress.getByName("localhost");
            System.out.println(ip02);// localhost/127.0.0.1
            InetAddress ip03 = InetAddress.getLocalHost();
            System.out.println(ip03);// DESKTOP-BT9P60R/192.168.0.120
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
