package testSocket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

// 模拟客户端连接服务器交互数据
public class Client {

    private Socket socket;

    public Client(){
        try {
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost",8080);
            System.out.println("与服务端建立连接！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            Thread thread = new Thread(() -> {
                try {
                    //通过socket获取输入流读取服务端发送过来的消息
                    InputStream in = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(isr);
                    String message;
                    while ((message = br.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.setDaemon(true);
            thread.start();
            //隐藏子类的名字,直接用超类引用去看待
            OutputStream out = socket.getOutputStream();//用socket获取输出流
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);//转换输出流
            BufferedWriter bw = new BufferedWriter(osw);//缓冲字符输出流
            PrintWriter pw = new PrintWriter(bw, true);//行刷新输出流


            Scanner scanner = new Scanner(System.in);
            System.out.println("开始聊天吧！");
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                pw.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                //关闭socket时会与服务端进行挥手操作
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
