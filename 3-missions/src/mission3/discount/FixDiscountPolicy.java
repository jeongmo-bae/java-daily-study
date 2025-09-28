package mission3.discount;

import mission3.member.Grade;
import mission3.member.Member;

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
