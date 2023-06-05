package study.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.core.member.Grade;
import study.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용이 되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌 경우 10% 할인이 적용이 되지 않아야한다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}