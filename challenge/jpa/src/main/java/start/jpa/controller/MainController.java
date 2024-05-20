package start.jpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import start.jpa.entity.Member;
import start.jpa.service.MemberServiceImpl;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MemberServiceImpl memberService;

    @GetMapping(value ={"/", "/main"})
    public String main(){
        return "main";
    }

    // 로그인
    @PostMapping("/login")
    public String loginId(@ModelAttribute Member member, HttpServletRequest request) {
        if(memberService.login(member, request)){
            return "main";
        }
        return "main";
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        memberService.logout(request, response);
    }
}
