package experiment.exp2.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String[] args) {
        byte rBuf[] = new byte[100];
        DatagramPacket packet = new DatagramPacket(rBuf, rBuf.length);
        try {
            DatagramSocket rs = new DatagramSocket(10100);
            rs.receive(packet);
            System.out.println(new String(packet.getData()).trim());
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
