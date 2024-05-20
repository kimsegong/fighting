package start.jpa.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import start.jpa.entity.Member;
import start.jpa.repository.MemberRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 전체 회원 조회
    @Override
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    // 회원 등록
    @Transactional
    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    // 로그인
    public boolean login(Member member, HttpServletRequest request) {
        Optional<Member> findMember = memberRepository.findByName(member.getName());

        if (findMember.isPresent()) {
            Member foundMember = findMember.get();
            if (foundMember.getPw().equals(member.getPw())) {
                HttpSession session = request.getSession();
                session.setAttribute("member", foundMember);
                return true;
            }
        }
        return false;
    }

    // 로그아웃
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.invalidate();

        try {
            response.sendRedirect(request.getContextPath() + "/main");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    @Override
    public void modifyMember(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String pw = request.getParameter("pw");

        Member member = Member.builder()
               .id(id)
               .name(name)
               .age(age)
               .pw(pw)
               .build();

        int modifyResult = memberRepository.update(member);

        if (modifyResult == 1) {
            HttpSession session = request.getSession();
            Member sessionMember = (Member) session.getAttribute("member");
            sessionMember.setName(name);
            sessionMember.setAge(age);
            sessionMember.setPw(pw);

        }
        new ResponseEntity<>(Map.of("modifyResult", modifyResult), HttpStatus.OK);

    }


    @Override
    public void deleteMember(Long id) {
      memberRepository.delete(id);
    }
}
