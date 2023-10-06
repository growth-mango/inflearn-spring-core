package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 회원 정보 조회
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정보 조회

    // 할인 정책이 바뀌며 FixDiscountPolicy -> RateDiscountPolicy로 변경이 필요해짐
        // 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 코드를 고쳐야 한다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


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
