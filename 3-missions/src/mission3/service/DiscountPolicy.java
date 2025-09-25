package mission3.service;

import mission3.domain.Member;

public interface DiscountPolicy {
    /**
     * @param Member, price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
