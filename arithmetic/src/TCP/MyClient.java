package TCP;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by shengliyi on 2017/5/7.
 */
public class MyClient {
    private BufferedWriter writer;
//    private PrintWriter writer;
    private Socket socket;

    private void connect() {
        try {
            socket = new Socket("192.168.1.13", 8998);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.write("胡晓东是傻逼");
            writer.flush();
//            writer.println("I'm a handsome.");
            System.out.println("完成连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.connect();

    }
}
