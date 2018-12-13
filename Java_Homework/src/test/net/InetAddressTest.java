package test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("myweb.com");
        System.out.println(address);

        InetAddress[] addresses = InetAddress.getAllByName("www.myweb.com");
        for (InetAddress tempAddress:addresses) {
            System.out.println(tempAddress);
        }

    }
}
