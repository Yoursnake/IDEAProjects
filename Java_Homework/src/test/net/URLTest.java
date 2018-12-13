package test.net;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Port: " + url.getPort());
        System.out.println("Host: " + url.getHost());
        System.out.println("File: " + url.getFile());
        System.out.println("Ext: " + url.toExternalForm());
        System.out.println("-----------------------");

        URLConnection urlCon = url.openConnection();
        System.out.println("Date: " + new Date(urlCon.getDate()));
        System.out.println("Content-Type: " + urlCon.getContentType());
        System.out.println("Expires:" + urlCon.getExpiration());
        System.out.println("Last-Modified: " + new Date((urlCon.getLastModified())));
        int len = urlCon.getContentLength();
        System.out.println("Content-Length: " + len);
        System.out.println("Content: " + url.getContent());
    }
}
