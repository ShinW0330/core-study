package study.core.order;

import study.core.discount.DiscountPolicy;
import study.core.member.Member;
import study.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(DiscountPolicy discountPolicy , MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByid(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName, itemPrice, discountPrice);
    }
}
