package chat_room;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    private final static int VISIT_PORT = 8888;
    private final static String VISIT_IP = "127.0.0.1";
    private final static int LOCAL_PORT = 8889;

    private void load() {
        // 开线程监听 Socket
        new Thread(new ReceiveMsg()).start();

        /*发送Socket*/
        while(true) {
            // 键盘输入
            byte[] tempSendMsg = new byte[100];
            DataInputStream typeStream = new DataInputStream(System.in);
            for (int i = 0; i < tempSendMsg.length; i++) {
                try {
                    byte temp = typeStream.readByte();
                    if (temp == '\n') {
                        break;
                    }
                    tempSendMsg[i] = temp;
                } catch (IOException e) {
                    System.out.println("发送信息读取失败");
                }
            }

            // 关闭命令行输入流
            try {
                typeStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 发送Socket
            String sendMsg = new String(tempSendMsg).trim();
            try {
                Socket socket = new Socket(VISIT_IP, VISIT_PORT);
                DataOutputStream sendStream = new DataOutputStream(new BufferedOutputStream(
                        socket.getOutputStream()
                ));
                sendStream.writeUTF(sendMsg);
                sendStream.flush();

                sendStream.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("socket 创建失败");
            }
        }

    }

    private class ReceiveMsg implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(LOCAL_PORT);
                while (true) {
                    Socket socket = ss.accept();

                    DataInputStream dis = new DataInputStream(new BufferedInputStream(
                            socket.getInputStream()
                    ));

                    String receiveMsg = dis.readUTF();
                    System.out.println("对方：" + receiveMsg);
                    dis.close();
                }

            } catch (IOException e) {
                System.out.println("Socket 建立失败（监听）");
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.load();
    }
}
