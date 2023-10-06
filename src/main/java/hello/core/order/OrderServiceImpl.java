package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 회원 정보 조회
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정보 조회
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


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
