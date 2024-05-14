package start.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping(value ="/member.do")
    public String member(){
        return "member";
    }
}
