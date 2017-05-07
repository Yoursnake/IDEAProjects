import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            String localname = ip.getHostName();
            String localip = ip.getHostAddress();
            System.out.println("本机名：" + localname);
            System.out.println("本机 ip 地址：" + localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
