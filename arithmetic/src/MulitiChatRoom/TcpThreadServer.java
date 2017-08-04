package MulitiChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shengliyi on 2017/5/7.
 */
public class TcpThreadServer {

    //    ThreadPoolExecutor

    public static void main(String[] args) throws IOException {
        TcpThreadServer tcpServer = new TcpThreadServer();
        ServerSocket server = new ServerSocket(8998);
        while (true) {

            final Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        doClient(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }

    private static void doClient(Socket socket) throws IOException {
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket
                .getInputStream()));    // 读取从客户端发来的消息
        PrintWriter toClient = new PrintWriter(socket.getOutputStream()); // 向客户端写入消息
        String clientIp = fromClient.readLine();    // 第一条信息为客户端的 ip 地址
        System.out.println(clientIp + " 加入了活动室");

        String line = fromClient.readLine();
        while (line != null && line != "exit") {
            System.out.println(clientIp + ":" + line);
            line = fromClient.readLine();
        }

        System.out.println(clientIp + " 退出了");
        fromClient.close();
    }
}
