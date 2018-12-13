package homework.second.Socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9100);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        while (true) {
            dis.readUTF();
        }
    }
}
