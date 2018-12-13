package experiment.exp2.TCP;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            DataInputStream dis = new DataInputStream(new BufferedInputStream(
                    socket.getInputStream()
            ));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                    socket.getOutputStream()
            ));
            dos.writeUTF("Hello Server, this is Client!");
            dos.flush();
            System.out.println(dis.readUTF());
            dis.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
