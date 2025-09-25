package mission3;

import mission3.domain.Grade;
import mission3.domain.Member;
import mission3.repository.MemberRepository;
import mission3.repository.MemoryMemberRepository;
import mission3.service.MemberService;
import mission3.service.MemberServiceImpl;

public class MemberApp {
    private static final MemberRepository memberRepository = new MemoryMemberRepository();

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member1 = new Member(1L,"member1",Grade.BASIC);
        memberService.join(member1);

        System.out.println(memberService.findMember(member1.getId()).getId());
        System.out.println(memberService.findMember(member1.getId()).getName());
        System.out.println(memberService.findMember(member1.getId()).getGrade());

    }
}
