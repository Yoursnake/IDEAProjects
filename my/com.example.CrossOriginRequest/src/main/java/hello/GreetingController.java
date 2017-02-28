package hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shengliyi on 2017/2/12.
 */
@RestController
public class GreetingController {

    private final String templates = "Hello, %s";
    private AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World")String name){
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), name);
    }
}
