package mission3.service;

import mission3.domain.Grade;
import mission3.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int fixedDiscountAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return fixedDiscountAmount;
        } else{
            return 0;
        }
    }
}
