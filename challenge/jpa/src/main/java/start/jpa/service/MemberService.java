package start.jpa.service;


import start.jpa.entity.Member;

import java.util.List;

public interface MemberService {
    public List<Member> findMember();
    public Long saveMember(Member member);
}
