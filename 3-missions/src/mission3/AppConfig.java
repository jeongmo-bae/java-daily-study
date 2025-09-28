package mission3;

import mission3.discount.DiscountPolicy;
//import mission3.discount.FixDiscountPolicy;
import mission3.discount.RateDiscountPolicy;
import mission3.member.MemberRepository;
import mission3.member.MemberService;
import mission3.member.MemberServiceImpl;
import mission3.member.MemoryMemberRepository;
import mission3.order.OrderService;
import mission3.order.OrderServiceImpl;

public class AppConfig {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository);
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository,discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
