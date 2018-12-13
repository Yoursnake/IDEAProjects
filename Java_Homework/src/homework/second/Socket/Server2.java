package homework.second.Socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9100);
        server.accept();
        while (true) {

        }
    }
}
