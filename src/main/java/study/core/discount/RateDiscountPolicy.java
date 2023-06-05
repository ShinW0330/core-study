package study.core.discount;

import study.core.member.Grade;
import study.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    //private static final double DISCOUNT_RATE = 0.1;
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent/100;
        }
        return 0;
    }
}
