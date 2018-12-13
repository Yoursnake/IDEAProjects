package experiment.exp2.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080); // Serversocket 对象
            System.out.println("启动服务器");
            while (true) {
                System.out.println("等待客户端信息");
                Socket socket = ss.accept();    // 接受客户端请求

                DataInputStream dis = new DataInputStream(new BufferedInputStream(
                        socket.getInputStream()
                ));
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                        socket.getOutputStream()
                ));

                // 读取数据
                String readLine = dis.readUTF();
                System.out.println(readLine);

                // 输出数据
                dos.writeUTF("Hello Client, this is Server!");
                dos.flush();
                dis.close();
                dos.close();
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
