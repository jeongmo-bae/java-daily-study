package test.mission3.member;

import mission3.AppConfig;
import mission3.member.Grade;
import mission3.member.Member;
import mission3.member.MemberRepository;
import mission3.member.MemoryMemberRepository;
import mission3.member.MemberService;
import mission3.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService ;

    @BeforeEach
    public void beforeEach(){
//        MemberRepository memberRepository = new MemoryMemberRepository();
//        memberService = new MemberServiceImpl(memberRepository);
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

//    @AfterEach
//    public void afterEach(){
//        memberRepository.clearStorage();
//    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"member1", Grade.VIP);

        //when
        memberService.join(member);

        //then
        Assertions.assertEquals(
                member.getName(),
                memberService.findMember(1L).getName()
        );
    }

    @Test
    void findMember(){
        //given
        Member member = new Member(1L,"member1",Grade.BASIC);
        //when
        memberService.join(member);

        //then
        Assertions.assertEquals(
                member.getName(),
                memberService.findMember(member.getId()).getName()
        );

        Assertions.assertEquals(
                null,
                memberService.findMember(2L)
        );

    }

}
