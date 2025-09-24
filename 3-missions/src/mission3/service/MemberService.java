package mission3.service;

import mission3.domain.Member;
import mission3.repository.MemberRepository;
import mission3.repository.MemoryMemberRepository;

public class MemberService {
    MemberRepository memberRepository;
    public MemberService(MemoryMemberRepository memoryMemberRepository){
        memberRepository = memoryMemberRepository;
    }

    public void join(Member member){
        memberRepository.save(member);
    }

    public Member findMember(Member member){
        return memberRepository.findById(member.getId())
        .orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
