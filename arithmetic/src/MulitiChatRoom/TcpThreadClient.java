package MulitiChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by shengliyi on 2017/5/7.
 */
public class TcpThreadClient {
    private Socket socket;
    private InetAddress ip;

    public static void main(String[] args) throws IOException {
        TcpThreadClient client = new TcpThreadClient();
        client.socket = new Socket("127.0.0.1", 8998);

        System.out.println("一个客户端已经启动(name:" +
                client.socket.getInetAddress().getHostName() +")");
        client.communicate();
    }

    private void communicate() throws IOException {
        BufferedReader message = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket
                .getInputStream()));    // 接受从服务端发来的信息
        PrintWriter toServer = new PrintWriter(socket.getOutputStream());

        ip = InetAddress.getLocalHost();
        String localIp = ip.getHostAddress();
        toServer.println(localIp);  // 第一条信息为 ip 地址
        toServer.flush();

        while (true) {
            System.out.println("请输入，以end结尾，退出请输入exit:");
            String readLine = message.readLine();
            while (!readLine.toLowerCase().equals("end")
                    && !readLine.toLowerCase().equals("exit")) {
                toServer.println(readLine);
                readLine = message.readLine();
            }
            toServer.flush();
//            System.out.println("从服务端接受的信息为:" + fromServer.readLine());

            if (readLine.equals("exit")) {
                break;
            }
        }

        message.close();
        toServer.close();
    }
}
