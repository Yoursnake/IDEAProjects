package UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;

/**
 * Created by shengliyi on 2017/6/11.
 */
public class Weather extends Thread {
    String weather = "节目预报：八点有大型晚会，请收听";
    int port = 9898;
    InetAddress inetAddress = null;
    MulticastSocket socket = null;


    Weather() {
        try {
            inetAddress = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port); // 实例化多点广播套接字
            socket.setTimeToLive(1);    // 指定发送范围是本地网络
            System.out.println("has setTimeToLive");
            socket.joinGroup(inetAddress);  // 加入广播组
            System.out.println("Has joinGroup");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("1");
        }

    }

    @Override
    public void run() {
        while (true) {
            DatagramPacket packet = null;
            byte[] data = weather.getBytes();

            // 将数据打包
            packet = new DatagramPacket(data, data.length, inetAddress, port);
            System.out.println(new String(data));
            try {
                socket.send(packet);
                sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("2");
            }
        }
    }

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.start();
    }
}
