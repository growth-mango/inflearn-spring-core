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
            // member 정보를 repository에 넣은 것과
            // member 정보를 reposiroty에서 찾은 것이 같다면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 이렇게 된다.
            // member 가 (new member) findMember (find member)와 같다면 테스트를 통과한다!!!
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
        // given

        // when

        // then
    }
}