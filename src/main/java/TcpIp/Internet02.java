package TcpIp;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

// 测试查询网络Ip
public class Internet02 {
    public static void main(String[] args) {
        try {
            InetAddress ip01 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip01); // www.baidu.com/36.152.44.96
            System.out.println(ip01.getAddress());// [B@1b6d3586
            System.out.println(ip01.getCanonicalHostName());// 36.152.44.96
            System.out.println(ip01.getHostAddress());// 36.152.44.96
            System.out.println(ip01.getHostName());// www.baidu.com
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        InetSocketAddress localhost = new InetSocketAddress("www.baidu.com",8080);
        System.out.println(localhost);// www.baidu.com/36.152.44.95:8080
        System.out.println("=======================================");
        System.out.println(localhost.getAddress());// www.baidu.com/36.152.44.95
        System.out.println(localhost.getHostName());// www.baidu.com
        System.out.println(localhost.getPort());// 8080
    }
}
