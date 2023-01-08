package testSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟服务端接受客户端的数据
 */
public class Server {
    private ServerSocket serverSocket;
    private List<PrintWriter> allOut = new ArrayList<>();

    public Server(){
        try {
            System.out.println("正在启动服务器...");
            serverSocket = new ServerSocket(8080);
            System.out.println("服务端口启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            System.out.println("正在等待客户端连接...");
            Socket socket = serverSocket.accept(); // 等待客户端连接
            System.out.println("客户端连接了！");

            // 启动一个线程处理此次连接
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.run();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;

        public ClientHandler(Socket socket){
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress(); // 获取当前socket的IP地址
        }
        @Override
        public void run() {
            PrintWriter pw = null; // 创建一个输出流
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw,true);
                synchronized (allOut){
                    allOut.add(pw); // 分别添加每个客户端的流
                }
                System.out.println(host+"上线了,当前人数："+allOut.size());

                String message;

                while ((message = br.readLine()) !=null){
                    System.out.println(host + "说："+message);
                    synchronized (allOut){
                        for (PrintWriter o : allOut) {
                            o.println(host+"说："+message);
                        }
                    }
                }
            }catch (IOException e){
                System.out.println("有一个客户端异常断开了！！！");
                System.out.println(e.getMessage());
            }finally {
                synchronized (allOut){
                    allOut.remove(pw);
                }
                System.out.println(host+"下线了,当前人数："+allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
