package mission3;

import mission3.domain.Grade;
import mission3.domain.Member;
import mission3.domain.Order;
import mission3.repository.MemberRepository;
import mission3.repository.MemoryMemberRepository;
import mission3.service.DiscountPolicy;
import mission3.service.FixDiscountPolicy;
import mission3.service.MemberService;
import mission3.service.MemberServiceImpl;
import mission3.service.OrderService;
import mission3.service.OrderServiceImpl;

public class OrderApp {
    private static final MemberRepository memberRepository = new MemoryMemberRepository();
    private static final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private static final MemberService memberService = new MemberServiceImpl(memberRepository);
    private static final OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    public static void main(String[] args) {
        Member member1 = new Member(1L,"member1",Grade.VIP);
        memberService.join(member1);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order.toString());
    }

}
