package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shengliyi on 2017/2/9.
 */
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch){
        this.latch = latch;
    }

    /*这个方法是用来接收信息的，方法名可以随意改变*/
    public void receiveMessage(String message){
        logger.info("Received <" + message + ">");
        latch.countDown();
    }
}
