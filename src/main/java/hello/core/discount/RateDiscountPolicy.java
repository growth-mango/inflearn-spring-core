package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10 ;

    @Override
    public int discount(Member member, int price) {
        // enum은 == 씀 equals 아님
        // VIP면 10% 할인
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100 ;
        } else {
            return 0;
        }
    }
}
