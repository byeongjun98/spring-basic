package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
관심사의 분리
- 애플리케이션을 하나의 공연이라 생각하자. 각각의 인터페이스를 배역이라고 생각하자. 그렇다고 하면 실제 배역에 맞는 배우를 선택하는 것은 누가하는가?
- 공연의 역할을 누가 할지는 배우들이 정하는 것이 아니다.

관심사를 분리하자
- 배우는 본인의 역할인 배역을 수행하는 것에만 집중
- 디카프리오는 어떤 여자 주인공이 선택되더라도 똑같이 고영ㄴ
- 공연을 구성하고, 담당 배우를 섭외하고, 역할에 맞는 배우를 지정하는 책임을 담당하는 별도의 공연 기획자가 필요
- 공연 기획자를 만들고, 배우와 공연 기획자의 책음을 확실히 분리하자.

AppConfig는 애플리게이션의 실제 동작에 필요한 구현 객체를 생성한다.
생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입 해준다.
 */

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
