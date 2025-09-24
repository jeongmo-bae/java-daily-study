package mission3;

import mission3.domain.Grade;
import mission3.domain.Member;
import mission3.service.MemberService;
import mission3.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA", Grade.VIP);

        memberService.join(member);
        Member foundedMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("founded member = " + foundedMember.getName());
    }
}
