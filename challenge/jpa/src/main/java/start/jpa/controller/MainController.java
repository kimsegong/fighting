package start.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value ={"/", "/main.do"})
    public String main(){
        return "main";
    }
}
