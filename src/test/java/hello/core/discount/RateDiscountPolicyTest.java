package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip는 10% 할인이 적용되어야 한다")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVip", Grade.VIP);
        //when
        discountPolicy.discount(member, 10000);

        // import static org.assertj.core.api.Assertions.* 를 통해 스태틱으로 사용하면 Assertions. 생략 가능
        assertThat(discountPolicy.discount(member, 10000)).isEqualTo(1000);
        //then
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberVip", Grade.BASIC);
        //when
        discountPolicy.discount(member, 10000);

        assertThat(discountPolicy.discount(member, 10000)).isEqualTo(0);
        //then
    }

}