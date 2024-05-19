package start.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import start.jpa.entity.Member;
import start.jpa.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 회원 조회
    @Override
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    // 회원 등록
    @Transactional
    @Override
    public Long saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
      memberRepository.delete(id);
    }
}
