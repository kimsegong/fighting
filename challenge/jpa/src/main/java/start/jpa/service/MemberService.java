package start.jpa.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import start.jpa.entity.Member;

import java.util.List;

public interface MemberService {
    public List<Member> findMember();
    public void saveMember(Member member);
    public boolean login(Member member, HttpServletRequest request);
    public void logout(HttpServletRequest request, HttpServletResponse response);
    public void modifyMember(HttpServletRequest request);
    public void deleteMember(Long id);
}
