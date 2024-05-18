package start.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import start.jpa.entity.Member;
import start.jpa.service.MemberServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberServiceImpl memberService;

    // 회원조회
    @GetMapping(value ="/check")
    public String member(Model model){
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/check";
    }

    // 회원 등록
    @GetMapping(value ="/register")
    public String registerForm(){
        return "members/register";
    }

    @PostMapping(value ="/register")
    public String saveMember(Member member){
        memberService.saveMember(member);
        return "main";
    }
}
