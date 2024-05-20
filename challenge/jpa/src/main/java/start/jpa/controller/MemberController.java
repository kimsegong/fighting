package start.jpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import start.jpa.entity.Member;
import start.jpa.repository.MemberRepository;
import start.jpa.service.MemberServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberServiceImpl memberService;
    private final MemberRepository memberRepository;

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

    // 회원 수정
    @GetMapping(value ="/modifyMember")
    public String modifyMemberForm(Model model, Long id){
        List<Member> members = memberRepository.findById(id);
        if (!members.isEmpty()) {
            model.addAttribute("member", members.get(0));
        } else {
            throw new NoSuchElementException("Member not found with id: " + id);
        }
        return "members/modifyMember";
    }


    @PostMapping(value ="/modifyMember")
    public void modifyMember(HttpServletRequest request){
        memberService.modifyMember(request);
    }

    // 회원 삭제
}
