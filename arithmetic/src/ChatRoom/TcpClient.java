package ChatRoom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by shengliyi on 2017/5/7.
 */
public class TcpClient {

    Socket socket;

    public static void main(String[] args) throws Exception {
        TcpClient client = new TcpClient();
        client.socket = new Socket("127.0.0.1", 8998);
        System.out.println("一个客户端已经启动");
        client.communicate();
    }

    private void communicate() throws Exception {
        BufferedReader message;
        BufferedReader fromServer;
        PrintWriter toServer;
        while (true) {
            message = new BufferedReader(new InputStreamReader(System.in));
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer = new PrintWriter(socket.getOutputStream());

            String readLine = message.readLine();
            while (!readLine.toLowerCase().equals("end")
                    && !readLine.toLowerCase().equals("exit")) {
                toServer.println(readLine);
                readLine = message.readLine();
            }

            toServer.flush();
            if (readLine.equals("exit")) {
                break;
            }
        }

        message.close();
        toServer.close();
        fromServer.close();
    }
}
