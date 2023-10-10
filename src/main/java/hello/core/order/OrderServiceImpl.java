package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 회원 정보 조회

    // 인터페이스 : 구현부는 설계부(추상적인)만 의존하고 있음
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 할인 정보 조회

    // 할인 정책이 바뀌며 FixDiscountPolicy -> RateDiscountPolicy로 변경이 필요해짐
        // 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 코드를 고쳐야 한다.
        // 클라이언트인 OrderServiceImpl이 DiscountPolicy 인터페이스 뿐만 아니라 FixDisCountPolicy 구현 클래스도 함께 의존하고 있다. -> DIP 위반!!
            // 추상에만 의존하도록 (즉 인터페이스에만 의존하도록) 변경해야 한다.
        // 그래서 FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간, OrderServiceImpl의 소스코드를 변경해야 한다. -> OCP 위반!
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // final은 무조건 값이 할당되어야 하기 때문에 이렇게만 바꾸면 된다...? 이렇게 추상인터페이스에만 의존하도록!?
        // 그런데 구현체가 없는데 어떻게 코드를 실행할 수 있을까? Null Pointer Exception 발생한다...
        // 그래서 우짜노 ?




    @Override
    public Order createOrder(Long memberId, String itemmName, int itemPrice) {
        // 1. 멤버 찾기
        Member member = memberRepository.findById(memberId);
        // 2. discountpolicy에 멤버 넘기기
            // orderservice 나는 모르겠고 할인에 대해서는 discountPolicy 너가 알아서 해줘
            // 단일 책임 원칙이 잘 지켜짐
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 최종 생성된 정보를 반환하기
        return new Order(memberId, itemmName, itemPrice, discountPrice);
    }

}
