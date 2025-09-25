package test.mission3;

import mission3.domain.Grade;
import mission3.domain.Member;
import mission3.repository.MemberRepository;
import mission3.repository.MemoryMemberRepository;
import mission3.service.MemberService;
import mission3.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemberServiceTest {
    MemberService memberService ;

    @BeforeEach
    public void beforeEach(){
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
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
