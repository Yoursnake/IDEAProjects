package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shengliyi on 2017/1/18.
 */
@Controller
//@RequestMapping("/greeting")
public class HelloWorldController {
    private final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

//    @RequestMapping(method = RequestMethod.GET)
    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
