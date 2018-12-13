package homework.second;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HomePage {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        URLConnection urlCon = url.openConnection();
        int len = urlCon.getContentLength();

        if (len > 0) {
            System.out.println("Content:");
            InputStream inputStream = urlCon.getInputStream();

            BufferedReader bfreader = new BufferedReader(new InputStreamReader(inputStream));
            String temp = bfreader.readLine();
            while (temp != null) {
                System.out.println(temp);
                temp = bfreader.readLine();
            }

            bfreader.close();
            inputStream.close();
        } else {
            System.out.println("No Content Available");
        }
    }
}
