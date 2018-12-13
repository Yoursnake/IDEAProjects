package test.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080);
            while (true) {
                Socket socket = ss.accept();
                InputStream in = socket.getInputStream();

            }
        } catch (Exception e) {

        }
    }
}
