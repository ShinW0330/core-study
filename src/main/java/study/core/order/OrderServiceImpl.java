package study.core.order;

import study.core.discount.DiscountPolicy;
import study.core.discount.RateDiscountPolicy;
import study.core.member.Member;
import study.core.member.MemberRepository;
import study.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByid(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName, itemPrice, discountPrice);
    }
}
