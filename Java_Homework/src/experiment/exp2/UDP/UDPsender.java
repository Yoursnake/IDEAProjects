package experiment.exp2.UDP;

import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsender {
    public static void main(String[] args) {
        byte sBuf[] = new byte[100];
        System.out.println("Input the message you will send: ");
        DataInputStream dis = new DataInputStream(System.in);
        try {
            int i;
            for (i = 0; i < 100; i++) {
                byte inByte = dis.readByte();
                if (((char) inByte == '#')) {
                    break;
                }
                sBuf[i] = inByte;
            }
            DatagramSocket sk = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(
                    sBuf, i, InetAddress.getByName("localhost"), 10100
            );
            sk.send(packet);
            sk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
