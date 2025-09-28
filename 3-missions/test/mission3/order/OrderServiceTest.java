package test.mission3.order;

import mission3.AppConfig;
import mission3.discount.DiscountPolicy;
import mission3.discount.FixDiscountPolicy;
import mission3.member.*;
import mission3.order.Order;
import mission3.order.OrderService;
import mission3.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
//    MemberRepository memberRepository;
//    DiscountPolicy discountPolicy;
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach(){
//        memberRepository = new MemoryMemberRepository();
//        discountPolicy = new FixDiscountPolicy();
//        memberService = new MemberServiceImpl(memberRepository);
//        orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        String itemName = "itemA";
        int itemPrice = 10000;
        Member member = new Member(memberId, "qowjdah",Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,itemName,itemPrice);
        Assertions.assertEquals(
                1000,
                order.getDiscountPrice()
        );
    }
}
