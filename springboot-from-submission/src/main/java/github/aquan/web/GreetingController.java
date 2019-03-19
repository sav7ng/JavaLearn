package github.aquan.web;

import github.aquan.entity.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Class GreetingController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.19 13:11
 * @Version 1.0
 **/
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetionSubmit(@ModelAttribute Greeting greeting) { return "result"; }

}
