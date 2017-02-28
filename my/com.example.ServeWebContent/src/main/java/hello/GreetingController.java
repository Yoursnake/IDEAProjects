package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shengliyi on 2017/2/10.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",defaultValue = "World",required = false)String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
