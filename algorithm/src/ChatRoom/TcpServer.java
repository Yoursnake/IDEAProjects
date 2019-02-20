package ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shengliyi on 2017/5/7.
 */
public class TcpServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader fromClient = null, message = null;
        try {
            server = new ServerSocket(8998);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("等待...");
                socket = server.accept();
                System.out.println(
                        "客户端IP:" + socket.getInetAddress().getHostAddress() + "\n" +
                                "客户端主机名:" + socket.getInetAddress().getHostName()
                );
                fromClient = new BufferedReader(new InputStreamReader(socket
                        .getInputStream()));
                message = new BufferedReader(new InputStreamReader(System.in));
                String line = fromClient.readLine();
                System.out.println(socket.getInetAddress().getHostName() + ":");
                while (line != null && !line.equals("exit")) {
                    System.out.println(line);
                    line = fromClient.readLine();
                }
                System.out.println(socket.getInetAddress().getHostName() + "已退出");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (message != null) {
                    try {
                        message.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fromClient != null) {
                    try {
                        fromClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
