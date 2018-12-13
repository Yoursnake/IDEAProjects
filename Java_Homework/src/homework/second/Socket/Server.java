package homework.second.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket SServer = new ServerSocket(9000);
        double[] inputNum = new double[10];

        Socket receiveSocket = SServer.accept();
        DataInputStream receiveDIS = new DataInputStream(new BufferedInputStream(
                receiveSocket.getInputStream()
        ));

        // 接受 10 次 Socket 来接受 10 个数，每次接受完后发送一个确认 Socket 到客户端
        for (int i = 0; i < 10; i++) {
            inputNum[i] = receiveDIS.readDouble();
        }
        receiveDIS.close();

        // 计算平均值
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += inputNum[i];
        }
        double average = sum / inputNum.length;

        // 将平均值发送给客户端
        Socket SSendSocket = new Socket("localhost", 9001);
        DataOutputStream sendDOS = new DataOutputStream(new BufferedOutputStream(
                SSendSocket.getOutputStream()
        ));
        sendDOS.writeDouble(average);
        sendDOS.flush();
        sendDOS.close();
    }
}
