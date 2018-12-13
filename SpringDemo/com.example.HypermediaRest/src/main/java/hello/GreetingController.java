package hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by shengliyi on 2017/1/20.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")    //因为开头有注释@RestController 默认此方法有注释@RespondeBody
    public HttpEntity<Greeting> greeting(@RequestParam(value = "name",
            required = false,defaultValue = "World")String name){
        Greeting greeting = new Greeting(String.format(template, name));

        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());  //.greeting(name) name表示/greeting?name= 的值
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}
