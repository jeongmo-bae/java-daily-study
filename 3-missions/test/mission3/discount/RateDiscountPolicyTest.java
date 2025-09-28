package mission3.discount;

import mission3.member.Grade;
import mission3.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L,"qowjdha", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member,1500);

        //then
        Assertions.assertEquals(150,discount);
    }

    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(2L,"qowjdah2",Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member , 1500);

        //then
        Assertions.assertEquals(0,discount);
    }
}