package homework.second.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        ServerSocket CServer = new ServerSocket(9001);

        Scanner input = new Scanner(System.in);
        System.out.println("请输入10个数（使用空格分开，以回车结束）");
        double[] inputNum = new double[10];

        // 输入数据
        for (int i = 0; i < 10; i++) {
            inputNum[i] = input.nextDouble();
        }

        Socket CSendSocket = new Socket("localhost", 9000);
        DataOutputStream sendDOS = new DataOutputStream(new BufferedOutputStream(
                CSendSocket.getOutputStream()
        ));

        // 发送 10 次 Socket 来传送 10 个数，每次发送完等待服务器发送确认 Socket 后继续发送
        for (int i = 0; i < 10; i++) {
            sendDOS.writeDouble(inputNum[i]);
//            sendDOS.flush();        // 不 flush 服务端将接受不到数据
        }
        sendDOS.flush();
        sendDOS.close();

        // 接受服务端的平均值
        Socket receiveSocket = CServer.accept();
        DataInputStream receiveDIS = new DataInputStream(new BufferedInputStream(
                receiveSocket.getInputStream()
        ));
        double average = receiveDIS.readDouble();
        System.out.println("average:" + average);
        receiveDIS.close();

    }
}
