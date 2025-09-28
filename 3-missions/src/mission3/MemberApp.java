package mission3;

import mission3.member.Grade;
import mission3.member.Member;
import mission3.member.MemberRepository;
import mission3.member.MemoryMemberRepository;
import mission3.member.MemberService;
import mission3.member.MemberServiceImpl;

public class MemberApp {
    private static final MemberRepository memberRepository = new MemoryMemberRepository();

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member1 = new Member(1L,"member1",Grade.BASIC);
        memberService.join(member1);

        System.out.println(memberService.findMember(member1.getId()).getId());
        System.out.println(memberService.findMember(member1.getId()).getName());
        System.out.println(memberService.findMember(member1.getId()).getGrade());

    }
}
