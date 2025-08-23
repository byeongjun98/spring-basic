package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;


class StatefulServiceTest {

    /*
    최대한 단순히 설명하기 위해, 실제 쓰레드 사용 X
    ThreadA가 사용자 A 코드를 호출하고 ThreadB가 사용자 B 코드를 호출한다고 가정
    StatefulService 의 price 필드는 공유되는 필드인데, 특정 클라이언트가 값을 변경한다
    사용자 A의 주문금액은 10000원이 되어야 하는데, 20000원이라는 결과 출력
    실무에서 이런 경우를 종종 보는데, 이로인해 정말 해결하기 어려운 큰 문제 발생
    공유 빌드를 조심, 스프링 빈은 항상 무상태(stateless)로 설계
     */
    @Test
    void statefulServiceTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}