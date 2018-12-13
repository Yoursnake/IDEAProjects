package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shengliyi on 2017/1/17.
 */
@RestController
public class GettingController {

    private final AtomicLong counter = new AtomicLong();    //创建一个动态long型变量
    private String template = "Hello,%s";

    @RequestMapping("/greeting")
    public Getting getting(@RequestParam(value = "name",defaultValue = "World!")String name){
        return new Getting(counter.incrementAndGet(),String.format(template,name));
    }
}
