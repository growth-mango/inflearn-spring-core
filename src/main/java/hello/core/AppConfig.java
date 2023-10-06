package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // MemberServiceImpl
    // MemoryMemberRepository
    // OrderServiceImpl
    // FixDiscountPolicy
// AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
    // MemberServiceImpl -> MemoryMemberRepository
    // OrderServiceImpl -> MemoryMemberRepository, FixDiscountPolicy
public class AppConfig {

    // 역할들을 드러나게 하는게 중요하다.
    public MemberService memberService(){
        // 생성자 주입
            // 이로써 MemberServiceImpl(구현체)는 오로지 추상클래스인 MemberRepository 에만 의존하게 된다.
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
