package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shengliyi on 2017/1/17.
 */
@Component  //让其作为组件类，能被主类扫描到
public class ScheduleTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduleTasks.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportTime(){
        log.info("This time is {}", dateFormat.format(new Date()));
    }
}
