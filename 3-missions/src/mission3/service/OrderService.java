package mission3.service;

import mission3.domain.Member;

public interface OrderService {
    String order(Member member,String productCode,int price);
}
