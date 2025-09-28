package mission3;

import mission3.member.Grade;
import mission3.member.Member;
import mission3.order.Order;
import mission3.member.MemberRepository;
import mission3.member.MemoryMemberRepository;
import mission3.discount.DiscountPolicy;
import mission3.discount.FixDiscountPolicy;
import mission3.member.MemberService;
import mission3.member.MemberServiceImpl;
import mission3.order.OrderService;
import mission3.order.OrderServiceImpl;

public class OrderApp {
//    private static final MemberRepository memberRepository = new MemoryMemberRepository();
//    private static final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private static final MemberService memberService = new MemberServiceImpl(memberRepository);
//    private static final OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);


    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member1 = new Member(1L,"member1",Grade.VIP);
        memberService.join(member1);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order.toString());
    }

}
