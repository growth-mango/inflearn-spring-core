package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given : 어떤게 주어졌을 때 ,
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 이렇게 했을 때,
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 이렇게 된다.
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
        // given

        // when

        // then
    }
}