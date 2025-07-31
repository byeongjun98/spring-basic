package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

/*
    이전 강의(17. 새로운 할인 정책 개발)에서 추가한 할인 정책(RateDiscountPolicy) 를 적용하려면 기존 FixDiscountPolicy를 주석으로 막고
    RateDiscountPolicy를 추가해주어야 했다
    이는 OCP 위반 (클라이언트 코드 수정)

    DIP도 준수하고 있는 것 같지만 그렇지 않다

    현재(18. 새로운 할인 정책 적용과 문제점 강의 수강중) 클래스 의존관계를 분석해보면 추상 뿐만이 아니라 구현 클래스에도 의존하고 있다
    추상 : DiscountPolicy
    구현: FixDiscountPolicy, RateDiscountPolicy
 */
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public  OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
//        throw new IllegalStateException("테스트 실행 확인용!");


        System.out.println(discountPolicy);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
