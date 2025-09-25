package mission3.service;

import mission3.domain.Member;

public interface OrderService {
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
