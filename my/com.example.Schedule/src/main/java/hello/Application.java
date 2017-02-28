package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by shengliyi on 2017/1/17.
 */
@SpringBootApplication
@EnableScheduling      //使能够使用定时任务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
