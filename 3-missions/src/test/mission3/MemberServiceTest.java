package test.mission3;

import mission3.domain.Grade;
import mission3.domain.Member;
import mission3.service.MemberService;
import mission3.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L,"member1", Grade.VIP);

        //when
        memberService.join(member);

        //then
        Assertions.assertEquals(member.getName(),memberService.findMember(1L).getName());

    }
}
