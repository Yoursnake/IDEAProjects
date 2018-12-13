package chat_room;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8888;

    // 开启监听服务
    private void listen() throws IOException {
        ServerSocket socket = new ServerSocket(SERVER_PORT);
        System.out.println("启动服务器");
    }

    public static void main(String[] args) {

    }
}
